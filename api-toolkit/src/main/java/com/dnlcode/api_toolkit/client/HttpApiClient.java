package com.dnlcode.api_toolkit.client;

import com.dnlcode.api_toolkit.model.HttpRequestDetails;
import com.dnlcode.api_toolkit.util.HttpUtils;
import java.net.http.*;
import java.net.URI;
import java.util.List;
import java.util.Map;

public class HttpApiClient {
    private final HttpClient client = HttpClient.newBuilder().build();

    public HttpResponse<String> send(HttpRequestDetails requestDetails) throws Exception {
       
        String url = HttpUtils.buildUrlWithPathParams(requestDetails.getUrl(), requestDetails.getPathParams());
        url = HttpUtils.buildUrlWithQueryParams(url, requestDetails.getQueryParams());

        HttpRequest.Builder builder = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .version(requestDetails.getProtocolVersion())
            .timeout(java.time.Duration.ofMillis(requestDetails.getTimeoutMillis()));

        if (requestDetails.getHeaders() != null) {
            for (Map.Entry<String, List<String>> entry : requestDetails.getHeaders().entrySet()) {
                for (String value : entry.getValue()) {
                    builder.header(entry.getKey(), value);
                }
            }
        }

        if (requestDetails.getIdempotencyKey() != null) {
            builder.header("Idempotency-Key", requestDetails.getIdempotencyKey());
        }

        String method = requestDetails.getMethod().toUpperCase();
        HttpRequest.BodyPublisher bodyPublisher = requestDetails.getBody() != null
            ? HttpRequest.BodyPublishers.ofString(requestDetails.getBody())
            : HttpRequest.BodyPublishers.noBody();

        builder.method(method, bodyPublisher);

        HttpRequest request = builder.build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}