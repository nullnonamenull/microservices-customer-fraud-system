package com.poleszak.entity.dto;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {
}
