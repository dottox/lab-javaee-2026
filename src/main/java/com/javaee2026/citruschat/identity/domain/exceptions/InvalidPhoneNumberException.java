package com.javaee2026.citruschat.identity.domain.exceptions;

import com.javaee2026.citruschat.shared.application.exceptions.BusinessException;
import com.javaee2026.citruschat.shared.domain.errors.ErrorCode;

public class InvalidPhoneNumberException extends BusinessException {

	public InvalidPhoneNumberException(String message) {
		super(ErrorCode.INVALID_PHONE_NUMBER, message);
	}
}
