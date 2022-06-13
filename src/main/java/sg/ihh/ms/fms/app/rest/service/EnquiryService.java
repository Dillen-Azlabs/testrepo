package sg.ihh.ms.fms.app.rest.service;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.ihh.ms.fms.app.gw.controller.EmailController;
import sg.ihh.ms.fms.app.gw.model.EmailTemplate;
import sg.ihh.ms.fms.app.repository.EmailTemplateRepository;
import sg.ihh.ms.fms.app.repository.EnquiryRepository;
import sg.ihh.ms.fms.app.rest.model.BaseResponse;
import sg.ihh.ms.fms.app.rest.model.EnquiryRequest;
import sg.ihh.ms.fms.app.rest.model.EnquiryResponse;
import sg.ihh.ms.fms.app.util.property.Property;

@RestController
@RequestMapping(
        path = "enquiry",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
        consumes = MediaType.APPLICATION_JSON_VALUE
)
public class EnquiryService extends BaseService {

    @Autowired
    private EnquiryRepository enquiryRepository;
    @Autowired
    private EmailTemplateRepository emailRepository;

    public EnquiryService() {
        log = getLogger(this.getClass());
    }

    @PostMapping("")
    public BaseResponse makeEnquiry(@RequestBody @Valid EnquiryRequest request) {
        final String methodName = "makeEnquiry";
        start(methodName);
        BaseResponse response = new BaseResponse(HttpStatus.INTERNAL_SERVER_ERROR);

        // Step 1: Save to database
        String uid = UUID.randomUUID().toString();
        request.setUid(uid);
        boolean status = enquiryRepository.create(request);

        if (status) {

            EmailController ec = new EmailController();

            // Step 2: Send email to Administrator
            // Pull email template from database
            EmailTemplate etAdm = emailRepository.getTemplate(getProperty(Property.EMAIL_TEMPLATE_NAME_ENQ_ADM));

            // if email template not set properly, don't send email
            if (!etAdm.isNull()) {
                // Expecting FE to enforce biz logic requirement from IHH
                // If processing of raw data is required, dup a new instance of EnquiryRequest,
                // process logic before forwarding to EmailController
                ec.sendEnquiryAdministrator(request, etAdm);
            }

            // Step 3: Send email to Patient
            // Pull email template from database
            EmailTemplate etPtn = emailRepository.getTemplate(getProperty(Property.EMAIL_TEMPLATE_NAME_ENQ_PTN));

            // if email template not set properly, don't send email
            if (!etPtn.isNull()) {

                // Overwriting emailTemplate recipient's email with request payload's email as per specs
                etPtn.setRecipients(request.getEmail());

                // Expecting FE to enforce biz logic requirement from IHH
                // If processing of raw data is required, dup a new instance of EnquiryRequest,
                // process logic before forwarding to EmailController
                ec.sendEnquiryPatient(request, etPtn);
            }

            response = new EnquiryResponse(HttpStatus.OK, uid);
        }

        completed(methodName);
        return response;
    }
}
