package com.javaee2026.citruschat.identity.domain.exceptions;

import com.javaee2026.citruschat.shared.application.exceptions.BusinessException;
import com.javaee2026.citruschat.shared.domain.constants.ErrorMessages;
import com.javaee2026.citruschat.shared.domain.errors.ErrorCode;

public class UserAlreadyInactiveException extends BusinessException {

	public UserAlreadyInactiveException() {
		super(ErrorCode.USER_ALREADY_INACTIVE, ErrorMessages.USER_ALREADY_INACTIVE);
	}
}
