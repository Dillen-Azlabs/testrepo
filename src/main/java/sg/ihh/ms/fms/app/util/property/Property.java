package sg.ihh.ms.fms.app.util.property;

public class Property {

    private Property() {
        // Empty Constructor
    }

    // API GATEWAY
    public static final String API_BASE_URL             = "api.gw.base.url";
    public static final String API_SEND_EMAIL_URL       = "api.send.email.url";

    // OAUTH
    public static final String OAUTH_BASE_URL           = "oauth.base.url";
    public static final String OAUTH_HOST_NAME          = "oauth.host.name";
    public static final String OAUTH_CLIENT_ID          = "oauth.client.id";
    public static final String OAUTH_CLIENT_SECRET      = "oauth.client.secret";
    public static final String OAUTH_TOKEN_URL          = "oauth.token.url";
    public static final String OAUTH_CLIENT_SCOPES      = "oauth.client.scopes";

    // EMAIL TEMPLATES
    public static final String EMAIL_TEMPLATE_NAME_APPT = "email.template.name.appt";
}
