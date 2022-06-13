package sg.ihh.ms.fms.app.repository;

import java.util.Date;

import org.jdbi.v3.core.Handle;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.fms.app.rest.model.MaternityTourCancelRequest;
import sg.ihh.ms.fms.app.rest.model.MaternityTourCreateRequest;
import sg.ihh.ms.fms.app.rest.model.MaternityTourRescheduleRequest;

@Repository
public class MaternityTourRepository extends BaseRepository {

	public MaternityTourRepository() {
		log = getLogger(this.getClass());
	}

	public boolean create(MaternityTourCreateRequest request) {
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

		completed(methodName);
		return result;
	}

	public boolean reschedule(MaternityTourRescheduleRequest request) {
		final String methodName = "reschedule";
		start(methodName);

		boolean result = false;

		final String sql = "INSERT INTO maternity_tour_reschedule_form (uid, language_code, case_no, " +
				"email, preferred_hospital, tour_type, has_partner, preferred_date, preferred_timeslot, created_dt)" +
				"VALUES(:uid, :languageCode, :caseNo, :email, :preferredHospital, :tourType, :hasPartner, " +
				":preferredDateDB, :preferredTimeslot, :createdDt );";

		request.setCreatedDt(new Date());

		try (Handle handle = getHandle()) {
			int row = handle.createUpdate(sql).bindBean(request).execute();

			if (row != 0) {
				result = true;
			}

		} catch (Exception ex) {
			log.error(methodName, ex.getMessage());
		}

		completed(methodName);
		return result;
	}

	public boolean cancel(MaternityTourCancelRequest request) {
		final String methodName = "cancel";
		start(methodName);

		boolean result = false;

		final String sql = "INSERT INTO maternity_tour_cancel_form (uid, language_code, case_no, email, reason, created_dt)" +
				"VALUES(:uid, :languageCode, :caseNo, :email, :reason, :createdDt );";

		request.setCreatedDt(new Date());

		try (Handle handle = getHandle()) {
			int row = handle.createUpdate(sql).bindBean(request).execute();

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
