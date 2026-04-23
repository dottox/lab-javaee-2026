package com.javaee2026.citruschat.identity.application.results;

import com.javaee2026.citruschat.identity.domain.model.User;

public record RegisterUserResult(
        User user,
        String temporaryPassword
) {
}