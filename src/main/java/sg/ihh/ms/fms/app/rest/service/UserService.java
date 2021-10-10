package sg.ihh.ms.fms.app.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sg.ihh.ms.fms.app.rest.model.ListResponse;
import sg.ihh.ms.fms.app.repository.UserRepository;
import sg.ihh.ms.fms.app.rest.model.UserSearchRequest;

@RestController
@RequestMapping(path = "users", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class UserService extends BaseService {

    @Autowired
    private UserRepository userRepository;

    public UserService() {
        log = getLogger(this.getClass());
    }

    @PostMapping(path = "search", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ListResponse search(@RequestBody @Valid UserSearchRequest request) {
        final String methodName = "search";
        start(methodName);

        List<Map<String, Object>> list = new ArrayList<>();

        if (request.getType().equals("userId")) {
            list = userRepository.searchUserById(request.getValue());
        } else if (request.getType().equals("email")) {
            list = userRepository.searchUserByEmail(request.getValue());
        }

        ListResponse response = new ListResponse(HttpStatus.OK, list);

        completed(methodName);
        return response;
    }
}