package sg.ihh.ms.fms.app.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sg.ihh.ms.fms.app.repository.MaternityTourRepository;
import sg.ihh.ms.fms.app.rest.model.*;

import java.util.UUID;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "maternity-tour", produces = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE }, consumes = MediaType.APPLICATION_JSON_VALUE)
public class MaternityTourService extends BaseService {

	@Autowired
	private MaternityTourRepository maternityTourRepository;

	public MaternityTourService() {
		log = getLogger(this.getClass());
	}

	@PostMapping("create")
	public BaseResponse createTour(@RequestBody @Valid MaternityTourCreateRequest request) {
		final String methodName = "createTour";
		start(methodName);

		BaseResponse response = new BaseResponse(HttpStatus.INTERNAL_SERVER_ERROR);

		String uid = UUID.randomUUID().toString();
		request.setUid(uid);
		boolean status = maternityTourRepository.create(request);

		if (status) {
			response = new MaternityTourCreateResponse(HttpStatus.OK, uid);
		}

		completed(methodName);
		return response;
	}

	@PostMapping("reschedule")
	public BaseResponse rescheduleTour(@RequestBody @Valid MaternityTourRescheduleRequest request) {
		final String methodName = "rescheduleTour";
		start(methodName);

		BaseResponse response = new BaseResponse(HttpStatus.INTERNAL_SERVER_ERROR);
		String uid = UUID.randomUUID().toString();
		request.setUid(uid);

		boolean status = maternityTourRepository.reschedule(request);

		if(status) {
			response = new MaternityTourRescheduleResponse(HttpStatus.OK);
		}

		completed(methodName);
		return response;
	}

	@PostMapping("cancel")
	public BaseResponse cancelTour(@RequestBody @Valid MaternityTourCancelRequest request) {
		final String methodName = "cancelTour";
		start(methodName);

		BaseResponse response = new BaseResponse(HttpStatus.INTERNAL_SERVER_ERROR);
		String uid = UUID.randomUUID().toString();
		request.setUid(uid);

		boolean status = maternityTourRepository.cancel(request);

		if(status) {
			response = new BaseResponse(HttpStatus.OK);
		}

		completed(methodName);
		return response;
	}
}
