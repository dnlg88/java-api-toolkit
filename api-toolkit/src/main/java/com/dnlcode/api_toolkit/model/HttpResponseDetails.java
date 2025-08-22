package com.dnlcode.api_toolkit.model;

import java.net.http.HttpClient;
import java.util.List;
import java.util.Map;

public class HttpResponseDetails {
    private String url;
    private String method;
    private Map<String, List<String>> headers;
    private String body;
    private long responseTimestamp;
    private int statusCode;
    private HttpClient.Version protocolVersion;
    private String uri;
    private long elapsedTime;
    private String errorMessage;
    private List<String> cookies;
    private List<String> redirectUris;

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }

    public Map<String, List<String>> getHeaders() { return headers; }
    public void setHeaders(Map<String, List<String>> headers) { this.headers = headers; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }

    public long getResponseTimestamp() { return responseTimestamp; }

    public void setResponseTimestamp(long responseTimestamp) {
        this.responseTimestamp = responseTimestamp;
    }
    
    public int getStatusCode() { return statusCode; }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    
    public HttpClient.Version getProtocolVersion() { return protocolVersion; }

    public void setProtocolVersion(HttpClient.Version protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public String getUri() { return uri; }
    public void setUri(String uri) { this.uri = uri; }

    public long getElapsedTime() { return elapsedTime; }

    public void setElapsedTime(long elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public String getErrorMessage() { return errorMessage; }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<String> getCookies() { return cookies; }

    public void setCookies(List<String> cookies) {
        this.cookies = cookies;
    }

    public List<String> getRedirectUris() { return redirectUris; }

    public void setRedirectUris(List<String> redirectUris) {
        this.redirectUris = redirectUris;
    }
}
