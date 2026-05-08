package com.javaee2026.citruschat.identity.infrastructure.web.mapper;

import com.javaee2026.citruschat.identity.application.commands.ValidateUserAccountCommand;
import com.javaee2026.citruschat.identity.infrastructure.web.dto.request.ValidateUserAccountRequest;
import com.javaee2026.citruschat.identity.infrastructure.web.dto.response.ValidateUserAccountResponse;

public final class ValidateUserAccountWebMapper {

	private ValidateUserAccountWebMapper() {
	}

	public static ValidateUserAccountCommand toCommand(ValidateUserAccountRequest request) {
		return new ValidateUserAccountCommand(request.username(), request.temporaryPassword(), request.newPassword());
	}

	public static ValidateUserAccountResponse toResponse(ValidateUserAccountRequest request) {
		return new ValidateUserAccountResponse(request.username(), true);
	}
}
