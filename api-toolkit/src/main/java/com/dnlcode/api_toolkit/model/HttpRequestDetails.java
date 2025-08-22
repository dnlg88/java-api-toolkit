package com.dnlcode.api_toolkit.model;

import java.net.http.HttpClient;
import java.util.Map;
import java.util.List;

public class HttpRequestDetails {
    private String url;
    private String method;
    private Map<String, List<String>> headers;
    private Map<String, String> queryParams;
    private String body;
    private HttpClient.Version protocolVersion = HttpClient.Version.HTTP_2;
    private long requestTimestamp;
    private int timeoutMillis;
    private Map<String, String> pathParams;
    private String contentType;
    private String charset;
    private boolean followRedirects;
    private String idempotencyKey;
    private String requestId;
    private Map<String, String> customTags;

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getMethod() { return method; }

    public void setMethod(String method) {
        this.method = method;
    }

    public HttpClient.Version getProtocolVersion() { return protocolVersion; }
    public void setProtocolVersion(HttpClient.Version protocolVersion) { this.protocolVersion = protocolVersion; }

    public Map<String, List<String>> getHeaders() { return headers; }
    public void setHeaders(Map<String, List<String>> headers) { this.headers = headers; }

    public Map<String, String> getQueryParams() { return queryParams; }
    public void setQueryParams(Map<String, String> queryParams) { this.queryParams = queryParams; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }

    public long getRequestTimestamp() { return requestTimestamp; }
    public void setRequestTimestamp(long requestTimestamp) { this.requestTimestamp = requestTimestamp; }

    public int getTimeoutMillis() { return timeoutMillis; }
    public void setTimeoutMillis(int timeoutMillis) { this.timeoutMillis = timeoutMillis; }

    public Map<String, String> getPathParams() { return pathParams; }
    public void setPathParams(Map<String, String> pathParams) { this.pathParams = pathParams; }

    public String getContentType() { return contentType; }
    public void setContentType(String contentType) { this.contentType = contentType; }

    public String getCharset() { return charset; }
    public void setCharset(String charset) { this.charset = charset; }

    public boolean isFollowRedirects() { return followRedirects; }
    public void setFollowRedirects(boolean followRedirects) { this.followRedirects = followRedirects; }

    public String getIdempotencyKey() { return idempotencyKey; }
    public void setIdempotencyKey(String idempotencyKey) { this.idempotencyKey = idempotencyKey; }

    public String getRequestId() { return requestId; }
    public void setRequestId(String requestId) { this.requestId = requestId; }

    public Map<String, String> getCustomTags() { return customTags; }
    public void setCustomTags(Map<String, String> customTags) { this.customTags = customTags; }
}
