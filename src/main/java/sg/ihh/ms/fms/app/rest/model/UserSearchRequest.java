package sg.ihh.ms.fms.app.rest.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserSearchRequest {

    @JsonProperty("type")
    @Pattern(regexp = "^(userId|email)$", message = "Allowed Values : userId or email")
    @NotBlank(message = "type is mandatory")
    private String type;

    @JsonProperty("value")
    @NotBlank(message = "value is mandatory")
    private String value;

    public UserSearchRequest() {
        // Empty Constructor
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
