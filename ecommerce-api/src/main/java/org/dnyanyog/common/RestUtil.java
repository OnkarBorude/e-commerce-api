package org.dnyanyog.common;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class RestUtil {
	
	public static String getRequest(String url) throws IOException, InterruptedException {
		HttpClient client=HttpClient.newHttpClient();
		
		HttpRequest request=HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
		
		HttpResponse<String> response=client.send(request, HttpResponse.BodyHandlers.ofString());
		return response.body();
	}
	
	public static String postRequest(String url, String body) throws IOException, InterruptedException {
		HttpClient client=HttpClient.newHttpClient();
		
		HttpRequest request=HttpRequest.newBuilder().uri(URI.create(url)).header("Content-Type", "application/xml").POST(HttpRequest.BodyPublishers.ofString(body)).build();
		
		HttpResponse<String> response=client.send(request, HttpResponse.BodyHandlers.ofString());
		
		return response.body();
	}

}
