package sg.ihh.ms.fms.app.gw.controller;

import sg.ihh.ms.fms.app.gw.base.BaseAPIController;
import sg.ihh.ms.fms.app.gw.model.EmailTemplate;
import sg.ihh.ms.fms.app.gw.model.SendEmailRequest;
import sg.ihh.ms.fms.app.rest.model.AppointmentRequest;
import sg.ihh.ms.fms.app.rest.model.EnquiryRequest;
import sg.ihh.ms.fms.app.util.http.HTTPClient;
import sg.ihh.ms.fms.app.util.http.model.HTTPRequest;
import sg.ihh.ms.fms.app.util.http.model.HTTPResponse;
import sg.ihh.ms.fms.app.util.mail.MailTemplateHelper;
import sg.ihh.ms.fms.app.util.property.Property;

public class EmailController extends BaseAPIController {

    public EmailController() {
        log = getLogger(this.getClass());
    }

    public boolean sendAppointmentBooking(AppointmentRequest appt, EmailTemplate et) {
        final String methodName = "sendAppointmentBooking";
        start(methodName);

        String subject = MailTemplateHelper.buildAppointmentBookingSubject(appt, et.getSubject());
        String body = MailTemplateHelper.buildAppointmentBooking(appt, et.getTemplate());

        boolean sendEmailSuccessful = sendEmail(et, subject, body);

        completed(methodName);
        return sendEmailSuccessful;
    }

    public boolean sendEnquiryAdministrator(EnquiryRequest enquiryRequest, EmailTemplate et) {
        final String methodName = "sendEnquiryAdministrator";
        start(methodName);

        String subject = MailTemplateHelper.buildEnquirySubject(enquiryRequest, et.getSubject());
        String body = MailTemplateHelper.buildEnquiry(enquiryRequest, et.getTemplate());

        boolean sendEmailSuccessful = sendEmail(et, subject, body);

        completed(methodName);
        return sendEmailSuccessful;
    }

    public boolean sendEnquiryPatient(EnquiryRequest enquiryRequest, EmailTemplate et) {
        final String methodName = "sendEnquiryPatient";
        start(methodName);

        String subject = MailTemplateHelper.buildEnquirySubject(enquiryRequest, et.getSubject());
        String body = MailTemplateHelper.buildEnquiry(enquiryRequest, et.getTemplate());

        boolean sendEmailSuccessful = sendEmail(et, subject, body);

        completed(methodName);
        return sendEmailSuccessful;
    }

    private boolean sendEmail(EmailTemplate et, String subject, String body) {
        final String methodName = "sendEmail";
        start(methodName);
        HTTPRequest httpRequest = buildProtectedJsonAPIRequest(getProperty(Property.API_SEND_EMAIL_URL));

        // Sender
        SendEmailRequest emailRequest = new SendEmailRequest();
        emailRequest.setSender(et.getSender());

        // Recipients
        for (String recipient : et.getRecipients().split(",")) {
            emailRequest.addRecipient(recipient.trim());
        }

        // Subject
        emailRequest.setSubject(subject);

        // Body
        emailRequest.setBody(body);

        HTTPResponse httpResponse = HTTPClient.post(httpRequest, toJson(emailRequest));
        logResponse(methodName, httpResponse);

        completed(methodName);
        return httpResponse.getCode() == 200;
    }
}
