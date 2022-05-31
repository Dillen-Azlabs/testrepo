package sg.ihh.ms.fms.app.rest.model;

import org.springframework.http.HttpStatus;

public class MaternityTourRescheduleResponse extends BaseResponse {

    private String uid;

    public MaternityTourRescheduleResponse(HttpStatus status) {
        super(status);
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
