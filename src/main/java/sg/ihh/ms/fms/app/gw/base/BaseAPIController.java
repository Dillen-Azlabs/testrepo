package sg.ihh.ms.fms.app.gw.base;

import org.springframework.http.HttpStatus;
import sg.ihh.ms.fms.app.manager.AccessTokenManager;
import sg.ihh.ms.fms.app.util.http.model.HTTPContentType;
import sg.ihh.ms.fms.app.util.http.model.HTTPRequest;
import sg.ihh.ms.fms.app.util.http.model.HTTPResponse;
import sg.ihh.ms.fms.app.util.json.JsonUtil;
import sg.ihh.ms.fms.app.util.property.Property;

public class BaseAPIController extends BaseController {

    private static final String BEARER = "Bearer ";

    public BaseAPIController() {
        // Empty Constructor
    }

    protected HTTPRequest buildProtectedJsonAPIRequest(String url) {
        return new HTTPRequest.Builder(getProperty(Property.API_BASE_URL) + url)
                .setContentType(HTTPContentType.APPLICATION_JSON).setAuthorization(BEARER + getAccessToken())
                .build();
    }

    protected HTTPRequest buildAPIRequest(String url) {
        return new HTTPRequest.Builder(getProperty(Property.API_BASE_URL) + url)
                .setContentType(HTTPContentType.APPLICATION_JSON).build();
    }

    private String getAccessToken() {
        return AccessTokenManager.getInstance().getAccessToken();
    }

    protected <T> T parseResponse(HTTPResponse response, Class<T> clazz) {
        return JsonUtil.fromJson(response.getBody(), clazz);
    }

    protected void logRequest(String methodName, Object request) {
        log.debug(methodName, "Request: " + toJson(request));
    }

    protected void logResponse(String methodName, Object response) {
        log.debug(methodName, "Response :" + toJson(response));
    }

    protected void logResponse(String methodName, HTTPResponse response) {
        log.debug(methodName, "Response :" + response.getCode() + " : " + toJson(response.getBody()));
    }

    protected void logErrorResponse(String methodName, HTTPResponse response) {
        log.error(methodName, "Response :" + response.getCode() + " : " + toJson(response.getBody()));
    }

    protected void logRequest(String methodName, HTTPRequest request, Object obj) {
        log.debug(methodName, "Request URL : " + request.getUrl());
        log.debug(methodName, "Request Body : " + toJson(obj));
    }

    protected String toJson(Object obj) {
        return JsonUtil.toJson(obj);
    }

    protected <T> T fromJson(String str, Class<T> clazz) {
        return JsonUtil.fromJson(str, clazz);
    }

    protected <T> T fromResponse(HTTPResponse response, Class<T> clazz) {
        return JsonUtil.fromJson(response.getBody(), clazz);
    }

    protected boolean isSuccessResponse(HTTPResponse response) {
        return isStatus(response, HttpStatus.OK);
    }

    protected boolean isStatus(HTTPResponse response, HttpStatus status) {
        return response.getCode() == status.value();
    }

    protected boolean checkStatus(HTTPResponse httpResponse, HttpStatus status) {
        return httpResponse.getCode() == status.value();
    }
}
