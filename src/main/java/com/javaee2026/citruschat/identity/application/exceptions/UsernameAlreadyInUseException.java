package com.javaee2026.citruschat.identity.application.exceptions;

import com.javaee2026.citruschat.shared.application.exceptions.BusinessException;
import com.javaee2026.citruschat.shared.domain.constants.ErrorMessages;
import com.javaee2026.citruschat.shared.domain.errors.ErrorCode;

public class UsernameAlreadyInUseException extends BusinessException {

	public UsernameAlreadyInUseException() {
		super(ErrorCode.USERNAME_ALREADY_IN_USE, ErrorMessages.USERNAME_ALREADY_IN_USE);
	}
}
