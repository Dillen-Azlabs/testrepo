package sg.ihh.ms.fms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MaternityTourCancelRequest extends MaternityTourBaseRequest{

    @JsonProperty("reason")
    private String reason;

    public String getReason() {
        return reason;
    }

    public void setReason() {
        this.reason = reason;
    }
}
