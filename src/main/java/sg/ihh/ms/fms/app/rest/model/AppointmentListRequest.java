package sg.ihh.ms.fms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class AppointmentListRequest {
    @JsonProperty("languageCode")
    @NotBlank(message = "Language Code is mandatory")
    private String languageCode;

    @JsonProperty("email")
    @Pattern(regexp = ".+@.+\\..+", message = "Allowed Value : email")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @JsonProperty("mostRecent")
    @Min(1)
    private int mostRecent;

    public AppointmentListRequest() {
        // Empty Constructor
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMostRecent() {
        return mostRecent;
    }

    public void setMostRecent(int mostRecent) {
        this.mostRecent = mostRecent;
    }
}
