package com.javaee2026.citruschat.identity.application.exceptions;

import com.javaee2026.citruschat.shared.application.exceptions.BusinessException;
import com.javaee2026.citruschat.shared.domain.constants.ErrorMessages;
import com.javaee2026.citruschat.shared.domain.errors.ErrorCode;

public class InvalidTemporaryPasswordException extends BusinessException {

	public InvalidTemporaryPasswordException() {
		super(ErrorCode.INVALID_TEMPORARY_PASSWORD, ErrorMessages.INVALID_TEMPORARY_PASSWORD);
	}
}
