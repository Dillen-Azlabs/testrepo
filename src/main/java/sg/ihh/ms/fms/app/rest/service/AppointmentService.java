package sg.ihh.ms.fms.app.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sg.ihh.ms.fms.app.gw.controller.EmailController;
import sg.ihh.ms.fms.app.gw.model.EmailTemplate;
import sg.ihh.ms.fms.app.repository.AppointmentRepository;
import sg.ihh.ms.fms.app.repository.EmailTemplateRepository;
import sg.ihh.ms.fms.app.rest.model.AppointmentRequest;
import sg.ihh.ms.fms.app.rest.model.AppointmentResponse;
import sg.ihh.ms.fms.app.rest.model.ServiceResponse;
import sg.ihh.ms.fms.app.util.property.Property;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(path = "appointments", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class AppointmentService extends BaseService {

    @Autowired
    private AppointmentRepository apptRepository;
    @Autowired
    private EmailTemplateRepository emailRepository;

    public AppointmentService() {
        log = getLogger(this.getClass());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ServiceResponse makeAppointment(@RequestBody @Valid AppointmentRequest request) {
        final String methodName = "makeAppointment";
        start(methodName);
        ServiceResponse response = new ServiceResponse(HttpStatus.INTERNAL_SERVER_ERROR);

        // Step 1: Save to database
        String uid = UUID.randomUUID().toString();
        request.setUid(uid);
        boolean status = apptRepository.create(request);

        // Step 2: Send email to Cention
        if (status) {
            // Pull email template from database
            EmailTemplate et = emailRepository.getTemplate(getProperty(Property.EMAIL_TEMPLATE_NAME_APPT));

            // if email template not set properly, don't send email
            if (!et.isNull()) {
                EmailController ec = new EmailController();
                // Expecting FE to enforce biz logic requirement from IHH
                // If processing of raw data is required, dup a new instance of AppointmentRequest,
                // process logic before forwarding to EmailController
                ec.sendAppointmentBooking(request, et);
            }

            response = new AppointmentResponse(HttpStatus.OK, uid);
        }

        completed(methodName);
        return response;
    }
}