package sg.ihh.ms.fms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import sg.ihh.ms.fms.app.util.date.DateUtil;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Date;

public class AppointmentRequest {

    @JsonProperty("uid")
    private String uid;

    @JsonProperty("createdDt")
    private Date createdDt;

    @JsonProperty("modifiedDt")
    private Date modifiedDt;

    @JsonProperty("languageCode")
    @NotBlank(message = "Language Code is mandatory")
    private String languageCode;

    @JsonProperty("bookingFor")
    @NotBlank(message = "Booking for is mandatory")
    private String bookingFor;

    @JsonProperty("caregiverFullName")
    private String caregiverFullName;

    @JsonProperty("caregiverCountry")
    private String caregiverCountry;

    @JsonProperty("caregiverEmail")
    @Pattern(regexp = ".+@.+\\..+", message = "Allowed Value : email")
    private String caregiverEmail;

    @JsonProperty("caregiverContact")
    private String caregiverContact;

    @JsonProperty("caregiverContactCountry")
    private String caregiverContactCountry;

    @JsonProperty("patientFullName")
    @NotBlank(message = "Patient Full Name for is mandatory")
    private String patientFullName;

    @JsonProperty("patientDob")
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])[-](19|20)\\d\\d$", message = "Allowed Value : DD-MM-YYYY")
    @NotBlank(message = "Patient Date of Birth is mandatory")
    private String patientDob;

    @JsonProperty("patientGender")
    @Pattern(regexp = "^(?:Male|Female)$", message = "Allowed Values : Male or Female")
    @NotBlank(message = "Patient Gender is mandatory")
    private String patientGender;

    @JsonProperty("patientIdType")
    @Pattern(regexp = "^(?:NRIC / FIN|Passport)$", message = "Allowed Values : NRIC / FIN or Passport")
    @NotBlank(message = "Patient ID Type is mandatory")
    private String patientIdType;

    @JsonProperty("patientIdValue")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Allowed Value : alphanumeric")
    @NotBlank(message = "Patient ID Value is mandatory")
    private String patientIdValue;

    @JsonProperty("patientNationality")
    @NotBlank(message = "Patient Nationality is mandatory")
    private String patientNationality;

    @JsonProperty("patientCountry")
    @NotBlank(message = "Patient Country of Residence is mandatory")
    private String patientCountry;

    @JsonProperty("nearestOffice")
    private String nearestOffice;

    @JsonProperty("patientEmail")
    @Pattern(regexp = ".+@.+\\..+", message = "Allowed Value : email")
    @NotBlank(message = "Patient Email is mandatory")
    private String patientEmail;

    @JsonProperty("patientContact")
    @NotBlank(message = "Patient Contact Number is mandatory")
    private String patientContact;

    @JsonProperty("patientContactCountry")
    private String patientContactCountry;

    @JsonProperty("preferredDoctor")
    private String preferredDoctor;

    @JsonProperty("medicalProfessionalURL")
    private String medicalProfessionalURL;

    @JsonProperty("specialty")
    private String specialty;

    @JsonProperty("reason")
    private String reason;

    @JsonProperty("preferredDate")
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])[-](19|20)\\d\\d$", message = "Allowed Value : DD-MM-YYYY")
    @NotBlank(message = "Preferred Appointment Date is mandatory")
    private String preferredDate;

    @JsonProperty("preferredTimeslot")
    @NotBlank(message = "Preferred Timeslot is mandatory")
    private String preferredTimeslot;

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

    public AppointmentRequest() {
        // Empty Constructor
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public String getBookingFor() {
        return bookingFor;
    }

    public void setBookingFor(String bookingFor) {
        this.bookingFor = bookingFor;
    }

    public String getCaregiverFullName() {
        return caregiverFullName;
    }

    public void setCaregiverFullName(String caregiverFullName) {
        this.caregiverFullName = caregiverFullName;
    }

    public String getCaregiverCountry() {
        return caregiverCountry;
    }

    public void setCaregiverCountry(String caregiverCountry) {
        this.caregiverCountry = caregiverCountry;
    }

    public String getCaregiverEmail() {
        return caregiverEmail;
    }

    public void setCaregiverEmail(String caregiverEmail) {
        this.caregiverEmail = caregiverEmail;
    }

    public String getCaregiverContact() {
        return caregiverContact;
    }

    public void setCaregiverContact(String caregiverContact) {
        this.caregiverContact = caregiverContact;
    }

    public String getCaregiverContactCountry() {
        return caregiverContactCountry;
    }

    public void setCaregiverContactCountry(String caregiverContactCountry) {
        this.caregiverContactCountry = caregiverContactCountry;
    }

    public String getPatientFullName() {
        return patientFullName;
    }

    public void setPatientFullName(String patientFullName) {
        this.patientFullName = patientFullName;
    }

    public String getPatientDob() {
        return patientDob;
    }

    public LocalDate getPatientDobDB() {
        if (patientDob != null )
            return DateUtil.parseDateFEtoBE(patientDob);
        else
            return null;
    }

    public void setPatientDob(String patientDob) {
        this.patientDob = patientDob;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public String getPatientIdType() {
        return patientIdType;
    }

    public void setPatientIdType(String patientIdType) {
        this.patientIdType = patientIdType;
    }

    public String getPatientIdValue() {
        return patientIdValue;
    }

    public void setPatientIdValue(String patientIdValue) {
        this.patientIdValue = patientIdValue;
    }

    public String getPatientNationality() {
        return patientNationality;
    }

    public void setPatientNationality(String patientNationality) {
        this.patientNationality = patientNationality;
    }

    public String getPatientCountry() {
        return patientCountry;
    }

    public void setPatientCountry(String patientCountry) {
        this.patientCountry = patientCountry;
    }

    public String getNearestOffice() {
        return nearestOffice;
    }

    public void setNearestOffice(String nearestOffice) {
        this.nearestOffice = nearestOffice;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getPatientContact() {
        return patientContact;
    }

    public void setPatientContact(String patientContact) {
        this.patientContact = patientContact;
    }

    public String getPatientContactCountry() {
        return patientContactCountry;
    }

    public void setPatientContactCountry(String patientContactCountry) {
        this.patientContactCountry = patientContactCountry;
    }

    public String getPreferredDoctor() {
        return preferredDoctor;
    }

    public void setPreferredDoctor(String preferredDoctor) {
        this.preferredDoctor = preferredDoctor;
    }

    public String getMedicalProfessionalURL() {
        return medicalProfessionalURL;
    }

    public void setMedicalProfessionalURL(String medicalProfessionalURL) {
        this.medicalProfessionalURL = medicalProfessionalURL;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getPreferredDate() {
        return preferredDate;
    }

    public LocalDate getPreferredDateDB() {
        if (preferredDate != null )
            return DateUtil.parseDateFEtoBE(preferredDate);
        else
            return null;
    }

    public void setPreferredDate(String preferredDate) {
        this.preferredDate = preferredDate;
    }

    public String getPreferredTimeslot() {
        return preferredTimeslot;
    }

    public void setPreferredTimeslot(String preferredTimeslot) {
        this.preferredTimeslot = preferredTimeslot;
    }

    public String getHospitalSource() {
        return hospitalSource;
    }

    public void setHospitalSource(String hospitalSource) {
        this.hospitalSource = hospitalSource;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
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
}
