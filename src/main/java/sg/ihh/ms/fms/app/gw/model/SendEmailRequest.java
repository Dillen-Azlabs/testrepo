package sg.ihh.ms.fms.app.gw.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class SendEmailRequest extends APIRequest {

    @JsonProperty("recipients")
    private List<String> recipientList;
    @JsonProperty("sender")
    private String sender;
    @JsonProperty("subject")
    private String subject;
    @JsonProperty("body")
    private String body;

    public SendEmailRequest() {
        super();
        this.recipientList = new ArrayList<>();
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<String> getRecipientList() {
        return recipientList;
    }

    public void setRecipientList(List<String> recipientList) {
        this.recipientList = recipientList;
    }

    public void addRecipient(String recipient) {
        recipientList.add(recipient);

    }

}
