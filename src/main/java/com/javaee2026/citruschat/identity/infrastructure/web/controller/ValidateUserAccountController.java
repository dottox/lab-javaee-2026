package com.javaee2026.citruschat.identity.infrastructure.web.controller;

import com.javaee2026.citruschat.identity.application.commands.ValidateUserAccountCommand;
import com.javaee2026.citruschat.identity.application.usecases.ValidateUserAccountUseCase;
import com.javaee2026.citruschat.identity.infrastructure.web.dto.request.ValidateUserAccountRequest;
import com.javaee2026.citruschat.identity.infrastructure.web.dto.response.ValidateUserAccountResponse;
import com.javaee2026.citruschat.shared.infrastructure.constants.ApiRoutes;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	@ResponseStatus(HttpStatus.OK)
	public ValidateUserAccountResponse validateAccount(@Valid @RequestBody final ValidateUserAccountRequest request) {
		validateUserAccountUseCase.execute(
				new ValidateUserAccountCommand(request.username(), request.temporaryPassword(), request.newPassword()));

		return new ValidateUserAccountResponse(request.username(), true);
	}
}
