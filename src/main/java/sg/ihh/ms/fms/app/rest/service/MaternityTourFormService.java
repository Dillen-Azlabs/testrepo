package sg.ihh.ms.fms.app.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sg.ihh.ms.fms.app.repository.MaternityTourFormRepository;
import sg.ihh.ms.fms.app.rest.model.BaseResponse;
import sg.ihh.ms.fms.app.rest.model.MaternityTourFormRequest;
import sg.ihh.ms.fms.app.rest.model.MaternityTourFormResponse;

import java.util.UUID;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "maternity-tour", produces = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE }, consumes = MediaType.APPLICATION_JSON_VALUE)
public class MaternityTourFormService extends BaseService {

	@Autowired
	private MaternityTourFormRepository formRepository;

	public MaternityTourFormService() {
		log = getLogger(this.getClass());
	}

	@PostMapping("create")
	public BaseResponse makeTourForm(@RequestBody @Valid MaternityTourFormRequest request) {
		final String methodName = "createForm";
		start(methodName);

		BaseResponse response = new BaseResponse(HttpStatus.INTERNAL_SERVER_ERROR);

		String uid = UUID.randomUUID().toString();
		request.setUid(uid);
		boolean status = formRepository.create(request);

		if (status) {
			response = new MaternityTourFormResponse(HttpStatus.OK, uid);
		}

		completed(methodName);
		return response;

	}
}
