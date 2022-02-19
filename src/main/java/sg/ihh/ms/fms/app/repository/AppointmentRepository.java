package sg.ihh.ms.fms.app.repository;

import org.jdbi.v3.core.Handle;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.fms.app.rest.model.AppointmentRequest;

import java.util.Date;

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
                "preferred_doctor_mcr, specialty, reason, preferred_date, preferred_timeslot, hospital_source, source_url, " +
                "receive_marketing, created_dt) " +
                "VALUES(:uid, :languageCode, :bookingFor, :caregiverFullName, :caregiverCountry, :caregiverEmail, " +
                " :caregiverContact, :caregiverContactCountry, :patientFullName, :patientDobDB, :patientGender, " +
                " :patientIdType, :patientIdValue, :patientNationality, :patientCountry, :nearestOffice, " +
                " :patientEmail, :patientContact, :patientContactCountry, :preferredDoctor, :preferredDoctorMcr, :specialty, :reason, " +
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

}
