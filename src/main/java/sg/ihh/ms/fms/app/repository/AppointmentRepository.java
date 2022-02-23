package sg.ihh.ms.fms.app.repository;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Query;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.fms.app.model.Appointment;
import sg.ihh.ms.fms.app.rest.model.AppointmentListRequest;
import sg.ihh.ms.fms.app.rest.model.AppointmentRequest;

import java.util.Date;
import java.util.List;

@Repository
public class AppointmentRepository extends BaseRepository {

    public AppointmentRepository() {
        log = getLogger(getClass());
    }

    public boolean create(AppointmentRequest appt) {
        final String methodName = "create";
        boolean result = false;

        final String sql = "INSERT INTO appointment_form (uid, language_code, booking_for, caregiver_full_name, " +
                "caregiver_cor, caregiver_email, caregiver_contact, caregiver_contact_country, patient_full_name, " +
                "patient_dob, patient_gender, patient_id_type, patient_id_value, patient_nationality, patient_cor, " +
                "nearest_office, patient_email, patient_contact, patient_contact_country, preferred_doctor, " +
                "medpro_url, specialty, reason, preferred_date, preferred_timeslot, hospital_source, source_url, " +
                "receive_marketing, created_dt) " +
                "VALUES(:uid, :languageCode, :bookingFor, :caregiverFullName, :caregiverCountry, :caregiverEmail, " +
                " :caregiverContact, :caregiverContactCountry, :patientFullName, :patientDobDB, :patientGender, " +
                " :patientIdType, :patientIdValue, :patientNationality, :patientCountry, :nearestOffice, " +
                " :patientEmail, :patientContact, :patientContactCountry, :preferredDoctor, :medicalProfessionalURL, :specialty, :reason, " +
                " :preferredDateDB, :preferredTimeslot, :hospitalSource, :sourceUrl, :receiveMarketing, :createdDt);";

        appt.setCreatedDt(new Date());

        try (Handle handle = getHandle()) {
            int row = handle.createUpdate(sql).bindBean(appt).execute();
            if (row != 0) {
                result = true;
            }
        } catch (Exception ex) {
            log.error(methodName, ex.getMessage());
        }
        log.debug(methodName, "CREATE STATUS: " + result);

        completed(methodName);
        return result;
    }



    public List<Appointment> list(AppointmentListRequest request) {
        final String methodName = "list";

        String langCode   = request.getLanguageCode();
        String email      = request.getEmail();
        int    mostRecent = request.getMostRecent();

        log.debug("langCode=[" + langCode + "] email=[" + email + "] mostRecent=[" + mostRecent + "]", methodName);

        final String sql = "SELECT uid as uid, language_code as languageCode, booking_for as bookingFor, " +
                "caregiver_full_name as caregiverFullName, caregiver_cor as caregiverCountry, caregiver_email as caregiverEmail, " +
                "caregiver_contact as caregiverContact, caregiver_contact_country as caregiverContactCountry, " +
                "patient_full_name as patientFullName, patient_dob as patientDobDB, patient_gender as patientGender, " +
                "patient_id_type as patientIdType, patient_id_value as patientIdValue, patient_nationality as patientNationality, " +
                "patient_cor as patientCountry, nearest_office as nearestOffice, patient_email as patientEmail, " +
                "patient_contact as patientContact, patient_contact_country as patientContactCountry, preferred_doctor as preferredDoctor, " +
                "medpro_url as medicalProfessionalURL, specialty as specialty, reason as reason, preferred_date as preferredDate, " +
                "preferred_timeslot as preferredTimeslot, hospital_source as hospitalSource, source_url as sourceUrl, " +
                "receive_marketing as receiveMarketing, created_dt as createdDt " +
                "FROM   appointment_form " +
                "WHERE  language_code = :langCode " +
                "  AND  ( caregiver_email = :caregiverEmail OR patient_email = :patientEmail ) " +
                "ORDER BY created_dt DESC " +
                "LIMIT :mostRecent";


        List<Appointment> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {

            query.bind("langCode",       langCode);
            query.bind("caregiverEmail", email);
            query.bind("patientEmail",   email);
            query.bind("mostRecent",     mostRecent);

            result = query.mapToBean(Appointment.class).list();
        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        completed(methodName);
        return result;
    }
}
