package sg.ihh.ms.fms.app.repository;

import java.util.Date;

import javax.validation.Valid;
import org.jdbi.v3.core.Handle;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.fms.app.rest.model.MaternityTourFormRequest;

@Repository
public class MaternityTourFormRepository extends BaseRepository {

	public MaternityTourFormRepository() {
		log = getLogger(this.getClass());
	}

	public boolean create(MaternityTourFormRequest request) {
		final String methodName = "create";
		start(methodName);

		boolean result = false;

		final String sql = "INSERT INTO maternity_tour_create_form (uid, language_code, case_no, mom_to_be_full_name, dob, " +
				"email, mobile_number, expected_dod, attending_gynae, other_gynae, has_prev_delivery, preferred_hospital,  " +
				"tour_type, has_partner, preferred_date, preferred_timeslot, accept_marketing, source_domain, created_dt) " +
				"VALUES(:uid, :languageCode, :caseNo, :momToBeFullName, :dobDB, :email, :mobileNumber, :expectedDodDB, " +
				":attendingGynae, :otherGynae, :hasPrevDelivery, :preferredHospital, :tourType, :hasPartner, :preferredDateDB,  " +
				":preferredTimeslot, :acceptMarketing, :sourceDomain, :createdDt);";

		request.setCreatedDt(new Date());

		try (Handle handle = getHandle()) {
			int row = handle.createUpdate(sql).bindBean(request).execute();

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
