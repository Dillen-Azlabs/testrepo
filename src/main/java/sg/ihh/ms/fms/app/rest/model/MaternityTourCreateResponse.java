package sg.ihh.ms.fms.app.rest.model;

import org.springframework.http.HttpStatus;

public class MaternityTourCreateResponse extends BaseResponse {

	private String uid;

    public MaternityTourCreateResponse(HttpStatus status, String uid) {
        super(status);
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
