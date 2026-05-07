package com.javaee2026.citruschat.identity.domain.exceptions;

import com.javaee2026.citruschat.shared.application.exceptions.BusinessException;
import com.javaee2026.citruschat.shared.domain.constants.ErrorMessages;
import com.javaee2026.citruschat.shared.domain.errors.ErrorCode;

public class UserAlreadyValidatedException extends BusinessException {

	public UserAlreadyValidatedException() {
		super(ErrorCode.USER_ALREADY_VALIDATED, ErrorMessages.USER_ALREADY_VALIDATED);
	}
}
