package com.nukk.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nukk.model.Customer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Optional;

@ApplicationScoped
public class AiAgentClient {

    @ConfigProperty(name = "ai.agent.url")
    Optional<String> aiAgentUrl;

    @Inject
    ObjectMapper objectMapper;

    private final HttpClient httpClient = HttpClient.newBuilder()
        .connectTimeout(Duration.ofSeconds(10))
        .build();

    public JsonNode analyze(Customer customer) {
        String url = aiAgentUrl.orElse("");
        if (url.isBlank()) {
            throw new AiAgentException(503, "AI_AGENT_URL is not configured for this app.");
        }
        try {
            String body = objectMapper.writeValueAsString(customer);
            String target = url.replaceAll("/+$", "") + "/analyze";
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(target))
                .timeout(Duration.ofSeconds(60))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() >= 400) {
                throw new AiAgentException(502, "AI agent returned status " + response.statusCode() + ": " + response.body());
            }

            return objectMapper.readTree(response.body());
        } catch (IOException e) {
            throw new AiAgentException(502, "Failed to reach AI agent: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AiAgentException(502, "Interrupted while calling AI agent: " + e.getMessage());
        }
    }

    public static class AiAgentException extends RuntimeException {
        public final int statusCode;

        public AiAgentException(int statusCode, String message) {
            super(message);
            this.statusCode = statusCode;
        }
    }
}
