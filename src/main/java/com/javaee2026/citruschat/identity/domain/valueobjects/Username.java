package com.javaee2026.citruschat.identity.domain.valueobjects;

import com.javaee2026.citruschat.shared.domain.constants.ErrorMessages;
import lombok.Getter;

@Getter
public final class Username {

    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 20;
    private static final String USERNAME_REGEX = "^[a-z0-9_]+$";

    private final String value;

    public Username(String raw) {
        if (raw == null) {
            throw new IllegalArgumentException(ErrorMessages.USERNAME_CANNOT_BE_NULL);
        }

        String normalized = normalize(raw);
        validate(normalized);
        this.value = normalized;
    }

    private String normalize(String input) {
        return input.trim().toLowerCase();
    }

    private void validate(String username) {
        if (username.isBlank()) {
            throw new IllegalArgumentException(ErrorMessages.USERNAME_CANNOT_BE_EMPTY);
        }

        if (username.length() < MIN_LENGTH || username.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(
                    ErrorMessages.usernameLengthBetween(MIN_LENGTH, MAX_LENGTH)
            );
        }

        if (!username.matches(USERNAME_REGEX)) {
            throw new IllegalArgumentException(ErrorMessages.USERNAME_INVALID_CHARACTERS);
        }

        if (username.startsWith("_") || username.endsWith("_")) {
            throw new IllegalArgumentException(ErrorMessages.USERNAME_INVALID_BOUNDARY_UNDERSCORE);
        }

        if (username.contains("__")) {
            throw new IllegalArgumentException(ErrorMessages.USERNAME_CONSECUTIVE_UNDERSCORES);
        }
    }
}