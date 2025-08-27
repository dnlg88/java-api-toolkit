package com.dnlcode.api_toolkit;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import com.dnlcode.api_toolkit.client.HttpApiClient;
import com.dnlcode.api_toolkit.model.HttpRequestDetails;
import com.dnlcode.api_toolkit.model.HttpResponseDetails;

public class ApiToolkitApplication {

	public static void main(String[] args) {
		System.out.println("ApiToolkit SDK iniciado.");
		try {
			HttpRequestDetails request = new HttpRequestDetails.Builder("https://jsonplaceholder.typicode.com/posts/1", "GET")
				.headers(Map.of("Accept", List.of("application/json")))
				.timeoutMillis(5000)
				.build();

			HttpApiClient client = new HttpApiClient();
			long requestStartTime = System.currentTimeMillis(); // Inicia el temporizador
			HttpResponse<String> response = client.send(request);
			// Process the response
			HttpResponseDetails responseDetails = new HttpResponseDetails.Builder(response.uri().toString(), response.request().method())
				.headers(response.headers().map())
				.body(response.body())
				.responseTimestamp(System.currentTimeMillis())
				.statusCode(response.statusCode())
				.protocolVersion(response.version())
				.cookies(response.headers().allValues("Set-Cookie"))
				.elapsedTime(System.currentTimeMillis() - requestStartTime) // Calcula el tiempo transcurrido
				.build();

			System.out.println("URL: " + responseDetails.getUrl());
			System.out.println("Status: " + responseDetails.getStatusCode());
			System.out.println("Response Timestamp: " + responseDetails.getResponseTimestamp());
			System.out.println("Elapsed Time: " + responseDetails.getElapsedTime() + " ms");
			System.out.println("Protocol Version: " + responseDetails.getProtocolVersion());
			System.out.println("Headers:");
			responseDetails.getHeaders().forEach((key, values) -> {
			    System.out.println(key + ": " + String.join(", ", values));
			});
			System.out.println("Cookies: " + responseDetails.getCookies());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
