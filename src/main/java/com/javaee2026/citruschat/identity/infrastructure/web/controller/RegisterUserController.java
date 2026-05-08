package com.javaee2026.citruschat.identity.infrastructure.web.controller;

import com.javaee2026.citruschat.identity.application.commands.RegisterUserCommand;
import com.javaee2026.citruschat.identity.application.results.RegisterUserResult;
import com.javaee2026.citruschat.identity.application.usecases.RegisterUserUseCase;
import com.javaee2026.citruschat.identity.infrastructure.web.dto.request.RegisterUserRequest;
import com.javaee2026.citruschat.identity.infrastructure.web.dto.response.RegisterUserResponse;
import com.javaee2026.citruschat.shared.infrastructure.constants.ApiRoutes;
import com.javaee2026.citruschat.shared.infrastructure.web.dto.ApiResponse;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterUserController {

	private final RegisterUserUseCase registerUserUseCase;

	public RegisterUserController(RegisterUserUseCase registerUserUseCase) {
		this.registerUserUseCase = registerUserUseCase;
	}

	@PostMapping(ApiRoutes.API_ADMIN_USERS)
	public ResponseEntity<ApiResponse<RegisterUserResponse>> register(@Valid @RequestBody RegisterUserRequest request) {
		RegisterUserCommand command = new RegisterUserCommand(request.email(), request.phoneNumber(),
				request.firstName(), request.lastName());

		RegisterUserResult result = registerUserUseCase.execute(command);

		RegisterUserResponse response = new RegisterUserResponse(result.user().getId().value().toString(),
				result.user().getEmail().getValue(), result.user().getUsername().getValue(),
				result.user().getPhoneNumber().getValue(), result.temporaryPassword());

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ApiResponse.success("User registered successfully", response));
	}
}
