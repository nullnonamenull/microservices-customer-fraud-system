package com.poleszak.apigateway.config;

public interface ApiKeyAuthorizationChecker {
    boolean isAuthorized(String key, String application);
}
