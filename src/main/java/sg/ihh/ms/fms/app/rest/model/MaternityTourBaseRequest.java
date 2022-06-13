package sg.ihh.ms.fms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class MaternityTourBaseRequest {
    @JsonProperty("uid")
    private String uid;

    @JsonProperty("createdDt")
    private Date createdDt;

    @JsonProperty("modifiedDt")
    private Date modifiedDt;

    @JsonProperty("languageCode")
    @NotBlank(message = "Language is mandatory")
    private String languageCode;

    @JsonProperty("caseNo")
    private String caseNo;

    @JsonProperty("email")
    @Pattern(regexp = ".+@.+\\..+", message = "Allowed Value : email")
    @NotBlank(message = "Email is mandatory")
    private String email;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedDt() {
        return createdDt;
    }
    
    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    public Date getModifiedDt() {
        return modifiedDt;
    }

    public void setModifiedDt(Date modifiedDt) {
        this.modifiedDt = modifiedDt;
    }
}
