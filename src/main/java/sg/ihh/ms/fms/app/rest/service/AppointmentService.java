package sg.ihh.ms.fms.app.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sg.ihh.ms.fms.app.repository.AppointmentRepository;
import sg.ihh.ms.fms.app.rest.model.AppointmentRequest;
import sg.ihh.ms.fms.app.rest.model.ServiceResponse;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "appointments", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class AppointmentService extends BaseService {

    @Autowired
    private AppointmentRepository apptRepository;

    public AppointmentService() {
        log = getLogger(this.getClass());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ServiceResponse makeAppointment(@RequestBody @Valid AppointmentRequest request) {
        final String methodName = "makeAppointment";
        start(methodName);

        // Step 1: Save to database
        boolean status = apptRepository.create(request);

        // Step 2: Send email to patient

        // Step 3: Send email to administrator

        ServiceResponse response = new ServiceResponse(HttpStatus.OK);

        completed(methodName);
        return response;
    }
}