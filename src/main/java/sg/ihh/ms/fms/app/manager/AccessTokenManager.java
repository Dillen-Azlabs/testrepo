package sg.ihh.ms.fms.app.manager;

import sg.ihh.ms.fms.app.manager.model.AccessTokenResponse;
import sg.ihh.ms.fms.app.util.http.HTTPClient;
import sg.ihh.ms.fms.app.util.http.model.HTTPContentType;
import sg.ihh.ms.fms.app.util.http.model.HTTPParameter;
import sg.ihh.ms.fms.app.util.http.model.HTTPRequest;
import sg.ihh.ms.fms.app.util.http.model.HTTPResponse;
import sg.ihh.ms.fms.app.util.json.JsonUtil;
import sg.ihh.ms.fms.app.util.property.Property;

import java.time.LocalDateTime;

public class AccessTokenManager extends BaseManager {

    private static AccessTokenManager instance;

    private String accessToken;
    private LocalDateTime expiryDt;

    private AccessTokenManager() {
        log = getLogger(this.getClass());
        updateToken();
    }

    public String getAccessToken() {
        if (expiryDt.isBefore(LocalDateTime.now())) {
            updateToken();
        }
        return accessToken;
    }

    private void updateToken() {
        accessToken = getClientToken();
        expiryDt = LocalDateTime.now().plusMinutes(30);
    }

    private String getClientToken() {
        final String methodName = "getClientToken";
        start(methodName);
        HTTPRequest request =
                new HTTPRequest.Builder(getProp(Property.OAUTH_BASE_URL) + getProp(Property.OAUTH_TOKEN_URL))
                        .setContentType(HTTPContentType.APPLICATION_FORM_URLENCODED).addHeader("Host", getHost()).build();

        log.info(getProp(Property.OAUTH_BASE_URL) + getProp(Property.OAUTH_TOKEN_URL));
        log.info(getHost());

        log.info(getProp(Property.OAUTH_CLIENT_ID));
        log.info(EncryptionManager.getInstance().decrypt(getProp(Property.OAUTH_CLIENT_SECRET)));
        log.info(getProp(Property.OAUTH_CLIENT_SCOPES));

        HTTPParameter params = new HTTPParameter();
        params.addParameter("client_id", getProp(Property.OAUTH_CLIENT_ID));
        params.addParameter("client_secret", EncryptionManager.getInstance().decrypt(getProp(Property.OAUTH_CLIENT_SECRET)));
        params.addParameter("scope", getProp(Property.OAUTH_CLIENT_SCOPES));
        params.addParameter("grant_type", "client_credentials");

        HTTPResponse httpResponse = HTTPClient.post(request, params);
        log.info("Code: " + httpResponse.getCode());
        log.info(httpResponse.getBody());

        AccessTokenResponse response = JsonUtil.fromJson(httpResponse.getBody(), AccessTokenResponse.class);

        completed(methodName);
        return response.getAccessToken();
    }

    public String getHost() {
        return getProp(Property.OAUTH_HOST_NAME);
    }

    public static AccessTokenManager getInstance() {
        if (instance == null) {
            instance = new AccessTokenManager();
        }
        return instance;
    }

    public void shutdown() {
        accessToken = null;
        expiryDt = null;
    }
}

