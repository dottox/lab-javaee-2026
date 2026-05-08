package com.javaee2026.citruschat.identity.infrastructure.web.dto.response;

public record CurrentUserResponse(String userId, String email, String username) {
}
