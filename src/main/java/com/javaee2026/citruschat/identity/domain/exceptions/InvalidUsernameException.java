package com.javaee2026.citruschat.identity.domain.exceptions;

import com.javaee2026.citruschat.shared.application.exceptions.BusinessException;
import com.javaee2026.citruschat.shared.domain.errors.ErrorCode;

public class InvalidUsernameException extends BusinessException {

	public InvalidUsernameException(String message) {
		super(ErrorCode.INVALID_USERNAME, message);
	}
}
