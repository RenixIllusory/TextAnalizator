package org.itproject.model;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TextAnalysisService {

    // Made by Renix

    private final HttpClient httpClient;
    private final Gson gson;
    private final String apiUrl;


    public TextAnalysisService(String apiUrl) {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
        this.apiUrl = apiUrl;
    }


    public TextAnalysisResult analyzeText(String text) throws Exception {
        AnalysisRequest request = new AnalysisRequest(text);
        String jsonPayload = gson.toJson(request);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
                .build();

        HttpResponse<String> response = httpClient.send(
                httpRequest,
                HttpResponse.BodyHandlers.ofString()
        );

        if (response.statusCode() == 200) {
            return gson.fromJson(response.body(), TextAnalysisResult.class);
        } else {
            throw new RuntimeException("API request failed: " + response.statusCode() +
                    "\nResponse: " + response.body());
        }
    }
}
