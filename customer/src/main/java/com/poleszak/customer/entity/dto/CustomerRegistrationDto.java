package com.poleszak.customer.entity.dto;

public record CustomerRegistrationDto(
        String firstName,
        String lastName,
        String email
) {
}
