package com.javaee2026.citruschat.identity.infrastructure.web.controller;

import com.javaee2026.citruschat.identity.application.commands.LoginCommand;
import com.javaee2026.citruschat.identity.application.results.LoginResult;
import com.javaee2026.citruschat.identity.application.usecases.LoginUserUseCase;
import com.javaee2026.citruschat.identity.infrastructure.web.dto.request.LoginRequest;
import com.javaee2026.citruschat.identity.infrastructure.web.dto.response.LoginResponse;
import com.javaee2026.citruschat.shared.domain.constants.ApiResponseMessages;
import com.javaee2026.citruschat.shared.infrastructure.constants.ApiRoutes;
import com.javaee2026.citruschat.shared.infrastructure.web.ApiResponses;
import com.javaee2026.citruschat.shared.infrastructure.web.dto.ApiResponse;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;

@RestController
public class LoginController {

	private final LoginUserUseCase loginUserUseCase;

	public LoginController(LoginUserUseCase loginUserUseCase) {
		this.loginUserUseCase = loginUserUseCase;
	}

	@GetMapping("/me")
	public ResponseEntity<?> me(@AuthenticationPrincipal Jwt jwt) {
		return ResponseEntity.ok(jwt.getClaims());
	}

	@PostMapping(ApiRoutes.API_AUTH_LOGIN)
	public ResponseEntity<ApiResponse<LoginResponse>> login(@Valid @RequestBody LoginRequest request) {
		LoginCommand command = new LoginCommand(request.email(), request.password());

		LoginResult result = loginUserUseCase.execute(command);

		LoginResponse response = new LoginResponse(result.user().getId().value().toString(),
				result.user().getEmail().getValue(), result.user().getUsername().getValue(), result.accessToken(),
				result.tokenType(), result.expiresIn());

		return ApiResponses.ok(ApiResponseMessages.LOGIN_SUCCESS, response);
	}
}
