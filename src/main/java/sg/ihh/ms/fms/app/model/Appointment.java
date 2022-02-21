package sg.ihh.ms.fms.app.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Appointment {

    @JsonProperty("uid")
    private String uid;

    @JsonProperty("createdDt")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDt;

    @JsonProperty("languageCode")
    private String languageCode;

    @JsonProperty("bookingFor")
    private String bookingFor;

    @JsonProperty("caregiverFullName")
    private String caregiverFullName;

    @JsonProperty("caregiverCountry")
    private String caregiverCountry;

    @JsonProperty("caregiverEmail")
    private String caregiverEmail;

    @JsonProperty("caregiverContact")
    private String caregiverContact;

    @JsonProperty("caregiverContactCountry")
    private String caregiverContactCountry;

    @JsonProperty("patientFullName")
    private String patientFullName;

    @JsonProperty("patientDob")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate patientDob;

    @JsonProperty("patientGender")
    private String patientGender;

    @JsonProperty("patientIdType")
    private String patientIdType;

    @JsonProperty("patientIdValue")
    private String patientIdValue;

    @JsonProperty("patientNationality")
    private String patientNationality;

    @JsonProperty("patientCountry")
    private String patientCountry;

    @JsonProperty("nearestOffice")
    private String nearestOffice;

    @JsonProperty("patientEmail")
    private String patientEmail;

    @JsonProperty("patientContact")
    private String patientContact;

    @JsonProperty("patientContactCountry")
    private String patientContactCountry;

    @JsonProperty("preferredDoctor")
    private String preferredDoctor;

    @JsonProperty("preferredDoctorMcr")
    private String preferredDoctorMcr;

    @JsonProperty("specialty")
    private String specialty;

    @JsonProperty("reason")
    private String reason;

    @JsonProperty("preferredDate")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate preferredDate;

    @JsonProperty("preferredTimeslot")
    private String preferredTimeslot;

    @JsonProperty("hospitalSource")
    private String hospitalSource;

    @JsonProperty("sourceUrl")
    private String sourceUrl;

    @JsonProperty("receiveMarketing")
    private String receiveMarketing;

    public Appointment() {
        // Empty Constructor
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public LocalDateTime getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(LocalDateTime createdDt) {
        this.createdDt = createdDt;
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

    public LocalDate getPatientDob() {
        return patientDob;
    }

    public void setPatientDob(LocalDate patientDob) {
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

    public String getPreferredDoctorMcr() {
        return preferredDoctorMcr;
    }

    public void setPreferredDoctorMcr(String preferredDoctorMcr) {
        this.preferredDoctorMcr = preferredDoctorMcr;
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

    public LocalDate getPreferredDate() {
        return preferredDate;
    }

    public void setPreferredDate(LocalDate preferredDate) {
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
