package sg.ihh.ms.fms.app.gw.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailTemplate {

    @JsonProperty("uid")
    private String uid;

    @JsonProperty("name")
    private String name;

    @JsonProperty("sender")
    private String sender;

    @JsonProperty("recipients")
    private String recipients;

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("template")
    private String template;

    public EmailTemplate() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public boolean isNull() {
        return ( sender==null && recipients==null && subject==null && template==null );
    }
}
