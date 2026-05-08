package com.javaee2026.citruschat.identity.application.exceptions;

import com.javaee2026.citruschat.shared.application.exceptions.BusinessException;
import com.javaee2026.citruschat.shared.domain.constants.ErrorMessages;
import com.javaee2026.citruschat.shared.domain.errors.ErrorCode;

public class InvalidCredentialsException extends BusinessException {

	public InvalidCredentialsException() {
		super(ErrorCode.INVALID_CREDENTIALS, ErrorMessages.INVALID_CREDENTIALS);
	}
}
