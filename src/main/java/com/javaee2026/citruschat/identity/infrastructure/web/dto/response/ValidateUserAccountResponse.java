package com.javaee2026.citruschat.identity.infrastructure.web.dto.response;

/**
 * Response returned after validating a user account.
 *
 * @param username
 *            validated username
 * @param validated
 *            indicates whether the account is validated
 */
public record ValidateUserAccountResponse(String username, boolean validated) {
}
