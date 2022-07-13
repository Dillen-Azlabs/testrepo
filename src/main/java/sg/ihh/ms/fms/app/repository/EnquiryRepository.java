package sg.ihh.ms.fms.app.repository;

import java.util.Date;

import org.jdbi.v3.core.Handle;
import org.springframework.stereotype.Repository;

import sg.ihh.ms.fms.app.rest.model.EnquiryRequest;

@Repository
public class EnquiryRepository extends BaseRepository {

    public EnquiryRepository() {
        log = getLogger(this.getClass());
    }

    public boolean create(EnquiryRequest enquiryRequest) {
        final String methodName = "create";
        start(methodName);

        boolean result = false;

        final String sql = "INSERT INTO enquiry_form (uid, language_code, full_name, email, mobile_number, cor, " +
                "nearest_office, enquiry, hospital_source, source_url, receive_marketing, created_dt, country_code, pdpa_declaration) " +
                "VALUES(:uid, :languageCode, :fullName, :email, :mobileNumber, :cor, :nearestOffice, :enquiry, " +
                ":hospitalSource, :sourceUrl, :receiveMarketing, :createdDt, :countryCode, :pdpaDeclaration );";

        enquiryRequest.setCreatedDt(new Date());

        try (Handle handle = getHandle()) {
            int row = handle.createUpdate(sql).bindBean(enquiryRequest).execute();

            if (row != 0) {
                result = true;
            }
        } catch (Exception ex) {
            log.error(methodName, ex.getMessage());
        }

        completed(methodName);
        return result;
    }
}
