package sg.ihh.ms.fms.app.gw.controller;

import sg.ihh.ms.fms.app.gw.base.BaseAPIController;
import sg.ihh.ms.fms.app.gw.model.EmailTemplate;
import sg.ihh.ms.fms.app.gw.model.SendEmailRequest;
import sg.ihh.ms.fms.app.rest.model.AppointmentRequest;
import sg.ihh.ms.fms.app.util.http.HTTPClient;
import sg.ihh.ms.fms.app.util.http.model.HTTPRequest;
import sg.ihh.ms.fms.app.util.http.model.HTTPResponse;
import sg.ihh.ms.fms.app.util.mail.MailTemplateHelper;
import sg.ihh.ms.fms.app.util.property.Property;

public class EmailController  extends BaseAPIController {

    public EmailController() {
        log = getLogger(this.getClass());
    }

    public boolean sendAppointmentBooking(AppointmentRequest appt, EmailTemplate et) {
        final String methodName = "sendAppointmentBooking";
        start(methodName);
        HTTPRequest httpRequest = buildProtectedJsonAPIRequest(getProperty(Property.API_SEND_EMAIL_URL));

        // Sender
        SendEmailRequest request = new SendEmailRequest();
        request.setSender(et.getSender());

        // Recipients
        for (String recipient : et.getRecipients().split(",")) {
            request.addRecipient(recipient.trim());
        }

        // Subject
        request.setSubject(et.getSubject());

        // Body
        String template = et.getTemplate();
        String body = MailTemplateHelper.buildAppointmentBooking(appt, template);
        request.setBody(body);

        HTTPResponse httpResponse = HTTPClient.post(httpRequest, toJson(request));
        logResponse(methodName, httpResponse);

        completed(methodName);
        return httpResponse.getCode() == 200;
    }

}
