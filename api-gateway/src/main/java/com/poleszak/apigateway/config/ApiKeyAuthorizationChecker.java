package com.poleszak.apigateway.config;

public interface ApiKeyAuthorizationChecker {
    boolean isAuthorized(String apiKey, String application);
}
