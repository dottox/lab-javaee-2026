package com.javaee2026.citruschat.identity.application.exceptions;

import com.javaee2026.citruschat.shared.application.exceptions.BusinessException;
import com.javaee2026.citruschat.shared.domain.constants.ErrorMessages;
import com.javaee2026.citruschat.shared.domain.errors.ErrorCode;

public class PhoneNumberAlreadyInUseException extends BusinessException {

	public PhoneNumberAlreadyInUseException() {
		super(ErrorCode.PHONE_NUMBER_ALREADY_IN_USE, ErrorMessages.PHONE_NUMBER_ALREADY_IN_USE);
	}
}
