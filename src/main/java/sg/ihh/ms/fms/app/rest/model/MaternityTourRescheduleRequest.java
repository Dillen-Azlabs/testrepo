package sg.ihh.ms.fms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import sg.ihh.ms.fms.app.util.date.DateUtil;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class MaternityTourRescheduleRequest extends MaternityTourBaseRequest{

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

    @JsonProperty("preferredDate")
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])[-](19|20)\\d\\d$", message = "Allowed Value : DD-MM-YYYY")
    @NotBlank(message = "Preferred Date is mandatory")
    private String preferredDate;

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