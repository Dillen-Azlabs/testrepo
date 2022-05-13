package sg.ihh.ms.fms.app.util.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sg.ihh.ms.fms.app.rest.model.AppointmentRequest;
import sg.ihh.ms.fms.app.rest.model.EnquiryRequest;
import sg.ihh.ms.fms.app.util.date.DateUtil;
import sg.ihh.ms.fms.app.util.string.StringHelper;

public class MailTemplateHelper {

    private static Logger log;

    static {
        log = LoggerFactory.getLogger(MailTemplateHelper.class);
    }

    // private constructor
    private MailTemplateHelper() {
    }

    public static String buildAppointmentBookingSubject(AppointmentRequest appt, String template) {
        String text = template;

        if (appt != null) {

            text = text.replace("${hospitalSource}",    StringHelper.emptyIfNull(appt.getHospitalSource()));
            text = text.replace("${preferredDate}",     StringHelper.emptyIfNull(appt.getPreferredDate()));
            text = text.replace("${preferredTimeslot}", StringHelper.emptyIfNull(appt.getPreferredTimeslot()));
            text = text.replace("${patientFullName}",   StringHelper.emptyIfNull(appt.getPatientFullName()));

        }
        return text;
    }

    public static String buildAppointmentBooking(AppointmentRequest appt, String template) {
        String text = template;

        if (appt != null) {

            text = text.replace("${sourceUrl}",             StringHelper.emptyIfNull(appt.getSourceUrl()));
            text = text.replace("${createdDate}",           DateUtil.getTodayDate());
            text = text.replace("${createdTime}",           DateUtil.getCurrenTime());

            // Appointment Details:
            text = text.replace("${preferredDoctor}",       StringHelper.emptyIfNull(appt.getPreferredDoctor()));
            text = text.replace("${specialty}",             StringHelper.emptyIfNull(appt.getSpecialty()));
            text = text.replace("${hospitalSource}",        StringHelper.emptyIfNull(appt.getHospitalSource()));
            text = text.replace("${preferredDate}",         StringHelper.emptyIfNull(appt.getPreferredDate()));
            text = text.replace("${preferredTimeslot}",     StringHelper.emptyIfNull(appt.getPreferredTimeslot()));
            text = text.replace("${reason}",                StringHelper.emptyIfNull(appt.getReason()));

            // Patient Information:
            text = text.replace("${patientFullName}",       StringHelper.emptyIfNull(appt.getPatientFullName()));
            text = text.replace("${patientNationality}",    StringHelper.emptyIfNull(appt.getPatientNationality()));
            text = text.replace("${patientCountry}",        StringHelper.emptyIfNull(appt.getPatientCountry()));
            text = text.replace("${nearestOffice}",         StringHelper.emptyIfNull(appt.getNearestOffice()));
            text = text.replace("${patientGender}",         StringHelper.emptyIfNull(appt.getPatientGender()));
            text = text.replace("${patientDob}",            StringHelper.emptyIfNull(appt.getPatientDob()));
            text = text.replace("${patientIdValue}",        StringHelper.emptyIfNull(appt.getPatientIdValue()));
            text = text.replace("${patientEmail}",          StringHelper.emptyIfNull(appt.getPatientEmail()));
            text = text.replace("${patientContact}",        StringHelper.emptyIfNull(appt.getPatientContact()));
            text = text.replace("${patientContactCountry}", StringHelper.emptyIfNull(appt.getPatientContactCountry()));

            // Additional Information:

            text = text.replace("${receiveMarketing}",      StringHelper.emptyIfNull(appt.getReceiveMarketing()));
            text = text.replace("${bookingFor}",            StringHelper.emptyIfNull(appt.getBookingFor()));
            text = text.replace("${caregiverFullName}",     StringHelper.emptyIfNull(appt.getCaregiverFullName()));
            text = text.replace("${caregiverEmail}",        StringHelper.emptyIfNull(appt.getCaregiverEmail()));
            text = text.replace("${caregiverCountry}",      StringHelper.emptyIfNull(appt.getCaregiverCountry()));
            text = text.replace("${caregiverContact}",      StringHelper.emptyIfNull(appt.getCaregiverContact()));
            text = text.replace("${caregiverContactCountry}", StringHelper.emptyIfNull(appt.getCaregiverContactCountry()));

        }
        return text;
    }

    public static String buildEnquirySubject(EnquiryRequest enquiryRequest, String template) {
        String text = template;

        if (enquiryRequest != null) {
            // Replace placeholders with values for customized subject
        }
        return text;
    }

    public static String buildEnquiry(EnquiryRequest enquiryRequest, String template) {
        String text = template;

        if (enquiryRequest != null) {

            text = text.replace("${createdDate}",           DateUtil.getTodayDate());
            text = text.replace("${createdTime}",           DateUtil.getCurrenTime());

            // Submission Details:
            text = text.replace("${hospitalSource}",        StringHelper.emptyIfNull(enquiryRequest.getHospitalSource()));
            text = text.replace("${sourceUrl}",             StringHelper.emptyIfNull(enquiryRequest.getSourceUrl()));

            // Enquiry Details
            text = text.replace("${fullName}",              StringHelper.emptyIfNull(enquiryRequest.getFullName()));
            text = text.replace("${email}",                 StringHelper.emptyIfNull(enquiryRequest.getEmail()));
            text = text.replace("${mobileNumber}",          StringHelper.emptyIfNull(enquiryRequest.getMobileNumber()));
            text = text.replace("${cor}",                   StringHelper.emptyIfNull(enquiryRequest.getCor()));
            text = text.replace("${nearestOffice}",         StringHelper.emptyIfNull(enquiryRequest.getNearestOffice()));

            text = text.replace("${enquiry}",               StringHelper.emptyIfNull(enquiryRequest.getEnquiry()));

            // Additional Information:
            text = text.replace("${receiveMarketing}",      StringHelper.emptyIfNull(enquiryRequest.getReceiveMarketing()));
        }
        return text;
    }
}
