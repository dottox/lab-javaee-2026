package com.javaee2026.citruschat.identity.infrastructure.web.controller;

import com.javaee2026.citruschat.identity.application.commands.ValidateUserAccountCommand;
import com.javaee2026.citruschat.identity.application.usecases.ValidateUserAccountUseCase;
import com.javaee2026.citruschat.identity.infrastructure.web.dto.request.ValidateUserAccountRequest;
import com.javaee2026.citruschat.identity.infrastructure.web.dto.response.ValidateUserAccountResponse;
import com.javaee2026.citruschat.shared.infrastructure.constants.ApiRoutes;

import com.javaee2026.citruschat.shared.infrastructure.web.dto.ApiResponse;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller responsible for validating user accounts.
 */

@RestController
public class ValidateUserAccountController {

	private final ValidateUserAccountUseCase validateUserAccountUseCase;

	/**
	 * Creates a new validate user account controller.
	 *
	 * @param validateUserAccountUseCase
	 *            use case used to validate accounts
	 */
	public ValidateUserAccountController(final ValidateUserAccountUseCase validateUserAccountUseCase) {
		this.validateUserAccountUseCase = validateUserAccountUseCase;
	}

	/**
	 * Validates a user account using a temporary password.
	 *
	 * @param request
	 *            request with username, temporary password and new password
	 * @return validation response
	 */
	@PostMapping(ApiRoutes.API_AUTH_VALIDATE_ACCOUNT)
	public ResponseEntity<ApiResponse<ValidateUserAccountResponse>> validateAccount(
			@Valid @RequestBody final ValidateUserAccountRequest request) {
		validateUserAccountUseCase.execute(
				new ValidateUserAccountCommand(request.username(), request.temporaryPassword(), request.newPassword()));

		ValidateUserAccountResponse response = new ValidateUserAccountResponse(request.username(), true);

		return ResponseEntity.ok(ApiResponse.success("Account validated successfully", response));
	}
}
