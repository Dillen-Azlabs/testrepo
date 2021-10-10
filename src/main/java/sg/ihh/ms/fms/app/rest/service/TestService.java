package sg.ihh.ms.fms.app.rest.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "test")
public class TestService extends BaseService {

    public TestService() {
        log = getLogger(this.getClass());
    }

    @GetMapping("/")
    public String index() {
        return "FMS Test OK!";
    }
}