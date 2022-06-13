package sg.ihh.ms.fms.app.gw.model;

import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonProperty;

public class APIRequest {
    @JsonProperty("securityHeader")
    private SecurityHeader securityHeader;

    public APIRequest() {
        securityHeader = new SecurityHeader(UUID.randomUUID().toString());
    }

    public SecurityHeader getSecurityHeader() {
        return securityHeader;
    }

    public void setSecurityHeader(SecurityHeader securityHeader) {
        this.securityHeader = securityHeader;
    }

}
