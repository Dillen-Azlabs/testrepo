package sg.ihh.ms.fms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import sg.ihh.ms.fms.app.util.date.DateUtil;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Date;

public class MaternityTourFormRequest {

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

	@JsonProperty("momToBeFullName")
	@Pattern(regexp = "^[a-zA-Z@',. -]+$", message = "Allowed Value : alphabets and symbols")
	@NotBlank(message = "Full Name is mandatory")
	private String momToBeFullName;

	@JsonProperty("email")
	@Pattern(regexp = ".+@.+\\..+", message = "Allowed Value : email")
	@NotBlank(message = "Email is mandatory")
	private String email;

	@JsonProperty("mobileNumber")
	@NotBlank(message = "Mobile Number is mandatory")
	private String mobileNumber;

	@JsonProperty("attendingGynae")
	@Pattern(regexp = "^[a-zA-Z@',. -]+$", message = "Allowed Value : alphabets and symbols")
	@NotBlank(message = "Attending Gynae Name is mandatory")
	private String attendingGynae;

	@JsonProperty("otherGynae")
	@Pattern(regexp = "^[a-zA-Z@',. -]+$", message = "Allowed Value : alphabets and symbols")
	private String otherGynae;

	@JsonProperty("hasPrevDelivery")
	private boolean hasPrevDelivery;

	@JsonProperty("preferredHospital")
	@Pattern(regexp = "^(?:GEH|MEH|MNH|PEH)$", message = "Allowed Values : GEH, MEH, MNH  or PEH")
	@NotBlank(message = "Preferred Hospital Name is mandatory")
	private String preferredHospital;

	@JsonProperty("tourType")
	@Pattern(regexp = "^(?:Physical|Virtual)$", message = "Allowed Values : Physical or Virtual")
	@NotBlank(message = "Tour Type is mandatory")
	private String tourType;

	@JsonProperty("hasPartner")
	@NotNull(message = "Partner is mandatory")
	private boolean hasPartner;

	@JsonProperty("preferredTimeslot")
	@Pattern(regexp = "^(?:(?:([01]?\\d|2[0-3]):)?([0-5]?\\d):)?([0-5]?\\d)$", message = "Allowed Value : HH:mm:ss")
	@NotBlank(message = "Preferred Timeslot is mandatory")
	private String preferredTimeslot;

	@JsonProperty("acceptMarketing")
	@NotNull(message = "Receive Marketing is mandatory") 
	private boolean acceptMarketing;

	@JsonProperty("sourceDomain")
	@NotBlank(message = "Source Domain is mandatory")
	private String sourceDomain;

	@JsonProperty("dob")
	@Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])[-](19|20)\\d\\d$", message = "Allowed Value : DD-MM-YYYY")
	@NotBlank(message = "DateOfBirth is mandatory")
	private String dob;

	@JsonProperty("expectedDod")
	@Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])[-](19|20)\\d\\d$", message = "Allowed Value : DD-MM-YYYY")
	private String expectedDod;

	@JsonProperty("preferredDate")
	@Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])[-](19|20)\\d\\d$", message = "Allowed Value : DD-MM-YYYY")
	@NotBlank(message = "Preferred Date is mandatory")
	private String preferredDate;

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

	public String getMomToBeFullName() {
		return momToBeFullName;
	}

	public void setMomToBeFullName(String momToBeFullName) {
		this.momToBeFullName = momToBeFullName;
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

	public String getAttendingGynae() {
		return attendingGynae;
	}

	public void setAttendingGynae(String attendingGynae) {
		this.attendingGynae = attendingGynae;
	}

	public String getOtherGynae() {
		return otherGynae;
	}

	public void setOtherGynae(String otherGynae) {
		this.otherGynae = otherGynae;
	}

	public boolean isHasPrevDelivery() {
		return hasPrevDelivery;
	}

	public void setHasPrevDelivery(boolean hasPrevDelivery) {
		this.hasPrevDelivery = hasPrevDelivery;
	}

	public String getPreferredHospital() {
		return preferredHospital;
	}

	public void setPreferredHospital(String preferredHospital) {
		this.preferredHospital = preferredHospital;
	}

	public String getTourType() {
		return tourType;
	}

	public void setTourType(String tourType) {
		this.tourType = tourType;
	}

	public boolean isHasPartner() {
		return hasPartner;
	}

	public void setHasPartner(boolean hasPartner) {
		this.hasPartner = hasPartner;
	}

	public String getPreferredTimeslot() {
		return preferredTimeslot;
	}

	public void setPreferredTimeslot(String preferredTimeslot) {
		this.preferredTimeslot = preferredTimeslot;
	}

	public boolean isAcceptMarketing() {
		return acceptMarketing;
	}

	public void setAcceptMarketing(boolean acceptMarketing) {
		this.acceptMarketing = acceptMarketing;
	}

	public String getSourceDomain() {
		return sourceDomain;
	}

	public void setSourceDomain(String sourceDomain) {
		this.sourceDomain = sourceDomain;
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

	public LocalDate getDobDB() {
		if (dob != null)
			return DateUtil.parseDateFEtoBE(dob);
		else
			return null;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public LocalDate getExpectedDodDB() {
		if (expectedDod != null)
			return DateUtil.parseDateFEtoBE(expectedDod);
		else
			return null;
	}

	public void setExpectedDod(String expectedDod) {
		this.expectedDod = expectedDod;
	}

	public LocalDate getPreferredDateDB() {
		if (preferredDate != null)
			return DateUtil.parseDateFEtoBE(preferredDate);
		else
			return null;
	}

	public void setPreferredDate(String preferredDate) {
		this.preferredDate = preferredDate;
	}
}