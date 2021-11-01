package sg.ihh.ms.fms.app.util.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sg.ihh.ms.fms.app.rest.model.AppointmentRequest;
import sg.ihh.ms.fms.app.util.string.StringHelper;

public class MailTemplateHelper {

    private static Logger log;

    static {
        log = LoggerFactory.getLogger(MailTemplateHelper.class);
    }

    // private constructor
    private MailTemplateHelper() {
    }

    public static String buildAppointmentBooking(AppointmentRequest appt, String template) {
        String text = template;

        if (appt != null) {

            text = text.replace("${sourceUrl}",             StringHelper.emptyIfNull(appt.getSourceUrl()));

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

            // Additional Information:

            text = text.replace("${receiveMarketing}",      StringHelper.emptyIfNull(appt.getReceiveMarketing()));
            text = text.replace("${bookingFor}",            StringHelper.emptyIfNull(appt.getBookingFor()));
            text = text.replace("${caregiverFullName}",     StringHelper.emptyIfNull(appt.getCaregiverFullName()));
            text = text.replace("${caregiverEmail}",        StringHelper.emptyIfNull(appt.getCaregiverEmail()));
            text = text.replace("${caregiverCountry}",      StringHelper.emptyIfNull(appt.getCaregiverCountry()));
            text = text.replace("${caregiverContact}",      StringHelper.emptyIfNull(appt.getCaregiverContact()));

        }
        return text;
    }
}
