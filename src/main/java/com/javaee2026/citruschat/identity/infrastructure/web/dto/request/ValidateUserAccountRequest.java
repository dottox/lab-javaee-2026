package com.javaee2026.citruschat.identity.infrastructure.web.dto.request;

import jakarta.validation.constraints.NotBlank;

/**
 * Request used to validate a user account for the first time.
 *
 * @param username
 *            user username
 * @param temporaryPassword
 *            password generated during registration
 * @param newPassword
 *            password chosen by the user
 */
public record ValidateUserAccountRequest(@NotBlank String username, @NotBlank String temporaryPassword,
		@NotBlank String newPassword) {
}
