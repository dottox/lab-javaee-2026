package com.javaee2026.citruschat.messaging.domain.exceptions;

import com.javaee2026.citruschat.shared.application.exceptions.BusinessException;
import com.javaee2026.citruschat.shared.domain.errors.ErrorCode;

public class InvalidRoleException extends BusinessException {
	public InvalidRoleException(String message) {
		super(ErrorCode.INVALID_ROLE, message);
	}
}
