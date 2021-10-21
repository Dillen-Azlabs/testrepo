package sg.ihh.ms.fms.app.gw.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SecurityHeader {

    @JsonProperty("state")
    private String state;

    public SecurityHeader(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
