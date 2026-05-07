package com.javaee2026.citruschat.identity.domain.exceptions;

import com.javaee2026.citruschat.shared.application.exceptions.BusinessException;
import com.javaee2026.citruschat.shared.domain.errors.ErrorCode;

public class InvalidPersonNameException extends BusinessException {

	public InvalidPersonNameException(String message) {
		super(ErrorCode.INVALID_PERSON_NAME, message);
	}
}
