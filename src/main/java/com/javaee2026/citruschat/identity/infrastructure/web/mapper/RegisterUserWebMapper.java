package com.javaee2026.citruschat.identity.infrastructure.web.mapper;

import com.javaee2026.citruschat.identity.application.commands.RegisterUserCommand;
import com.javaee2026.citruschat.identity.application.results.RegisterUserResult;
import com.javaee2026.citruschat.identity.infrastructure.web.dto.request.RegisterUserRequest;
import com.javaee2026.citruschat.identity.infrastructure.web.dto.response.RegisterUserResponse;

public final class RegisterUserWebMapper {

	private RegisterUserWebMapper() {
	}

	public static RegisterUserCommand toCommand(RegisterUserRequest request) {
		return new RegisterUserCommand(request.email(), request.phoneNumber(), request.firstName(), request.lastName());
	}

	public static RegisterUserResponse toResponse(RegisterUserResult result) {
		return new RegisterUserResponse(result.user().getId().value().toString(), result.user().getEmail().getValue(),
				result.user().getUsername().getValue(), result.user().getPhoneNumber().getValue(),
				result.temporaryPassword());
	}
}
