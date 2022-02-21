package sg.ihh.ms.fms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.fms.app.model.Appointment;

import java.util.List;

public class AppointmentListResponse extends ServiceResponse {

    @JsonProperty("appointments")
    private List<Appointment> appointmentList;

    @JsonProperty("count")
    private int count;

    public AppointmentListResponse(HttpStatus status) {
        super(status);
    }

    public AppointmentListResponse(HttpStatus status, List<Appointment> appointmentList, int count) {
        super(status);
        this.appointmentList = appointmentList;
        this.count = count;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
