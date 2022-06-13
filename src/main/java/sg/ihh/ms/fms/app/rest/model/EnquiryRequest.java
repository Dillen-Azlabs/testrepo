package sg.ihh.ms.fms.app.rest.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnquiryRequest {

    @JsonProperty("uid")
    private String uid;

    @JsonProperty("createdDt")
    private Date createdDt;

    @JsonProperty("modifiedDt")
    private Date modifiedDt;

    @JsonProperty("languageCode")
    @NotBlank(message = "Language Code is mandatory")
    private String languageCode;

    @JsonProperty("fullName")
    @Pattern(regexp = "^[a-zA-Z@',. -]+$", message = "Allowed Value : alphabets and symbols")
    @NotBlank(message = "Full Name is mandatory")
    private String fullName;

    @JsonProperty("email")
    @Pattern(regexp = ".+@.+\\..+", message = "Allowed Value : email")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @JsonProperty("mobileNumber")
    @NotBlank(message = "Mobile Number is mandatory")
    private String mobileNumber;

    @JsonProperty("cor")
    @NotBlank(message = "Country of Residence is mandatory")
    private String cor;

    @JsonProperty("nearestOffice")
    @NotBlank(message = "Nearest Office is mandatory")
    private String nearestOffice;

    @JsonProperty("enquiry")
    @NotBlank(message = "Enquiry is mandatory")
    private String enquiry;

    @JsonProperty("hospitalSource")
    @NotBlank(message = "Hospital Source is mandatory")
    private String hospitalSource;

    @JsonProperty("sourceUrl")
    @NotBlank(message = "Source URL is mandatory")
    private String sourceUrl;

    @JsonProperty("receiveMarketing")
    @Pattern(regexp = "^(?:Yes|No)$", message = "Allowed Values : Yes or No")
    @NotBlank(message = "Receive Marketing is mandatory")
    private String receiveMarketing;

    public EnquiryRequest() {
        // Empty Constructor
    }

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getNearestOffice() {
        return nearestOffice;
    }

    public void setNearestOffice(String nearestOffice) {
        this.nearestOffice = nearestOffice;
    }

    public String getEnquiry() {
        return enquiry;
    }

    public void setEnquiry(String enquiry) {
        this.enquiry = enquiry;
    }

    public String getHospitalSource() {
        return hospitalSource;
    }

    public void setHospitalSource(String hospitalSource) {
        this.hospitalSource = hospitalSource;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getReceiveMarketing() {
        return receiveMarketing;
    }

    public void setReceiveMarketing(String receiveMarketing) {
        this.receiveMarketing = receiveMarketing;
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
