package com.javaee2026.citruschat.identity.infrastructure.web.dto.response;

public record RegisterUserResponse(
        String id,
        String email,
        String username,
        String phoneNumber,
        String temporaryPassword
) {
}