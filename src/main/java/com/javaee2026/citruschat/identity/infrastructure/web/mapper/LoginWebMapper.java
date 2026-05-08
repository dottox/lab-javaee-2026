package com.javaee2026.citruschat.identity.infrastructure.web.mapper;

import com.javaee2026.citruschat.identity.application.commands.LoginCommand;
import com.javaee2026.citruschat.identity.application.results.LoginResult;
import com.javaee2026.citruschat.identity.infrastructure.web.dto.request.LoginRequest;
import com.javaee2026.citruschat.identity.infrastructure.web.dto.response.LoginResponse;

public final class LoginWebMapper {

	private LoginWebMapper() {
	}

	public static LoginCommand toCommand(LoginRequest request) {
		return new LoginCommand(request.email(), request.password());
	}

	public static LoginResponse toResponse(LoginResult result) {
		return new LoginResponse(result.user().getId().value().toString(), result.user().getEmail().getValue(),
				result.user().getUsername().getValue(), result.accessToken(), result.tokenType(), result.expiresIn());
	}
}
