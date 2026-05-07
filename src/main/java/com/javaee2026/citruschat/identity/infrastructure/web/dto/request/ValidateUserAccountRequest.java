package com.javaee2026.citruschat.identity.infrastructure.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

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

public record ValidateUserAccountRequest(
		@NotBlank(message = "Username is required") @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters") @Pattern(regexp = "^[a-z0-9_]+$", message = "Username can only contain lowercase letters, numbers and underscore") String username,

		@NotBlank(message = "Temporary password is required") String temporaryPassword,

		@NotBlank(message = "New password is required") String newPassword) {
}
