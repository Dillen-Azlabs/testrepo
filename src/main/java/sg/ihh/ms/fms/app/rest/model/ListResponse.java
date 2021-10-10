package sg.ihh.ms.fms.app.rest.model;

import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ListResponse extends ServiceResponse {

    @JsonProperty("data")
    private List<Map<String, Object>> dataList;

    public ListResponse(HttpStatus status, List<Map<String, Object>> dataList) {
        super(status);
        this.dataList = dataList;
    }

    public List<Map<String, Object>> getDataList() {
        return dataList;
    }

    public void setDataList(List<Map<String, Object>> dataList) {
        this.dataList = dataList;
    }

}
