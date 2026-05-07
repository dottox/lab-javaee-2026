package com.javaee2026.citruschat.identity.application.exceptions;

import com.javaee2026.citruschat.shared.application.exceptions.BusinessException;
import com.javaee2026.citruschat.shared.domain.constants.ErrorMessages;
import com.javaee2026.citruschat.shared.domain.errors.ErrorCode;

public class UserNotFoundException extends BusinessException {

	public UserNotFoundException() {
		super(ErrorCode.USER_NOT_FOUND, ErrorMessages.USER_NOT_FOUND);
	}
}
