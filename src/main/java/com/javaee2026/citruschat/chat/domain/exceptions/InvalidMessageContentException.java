package com.javaee2026.citruschat.chat.domain.exceptions;

import com.javaee2026.citruschat.shared.application.exceptions.BusinessException;
import com.javaee2026.citruschat.shared.domain.errors.ErrorCode;

public class InvalidMessageContentException extends BusinessException {

	public InvalidMessageContentException(String message) {
		super(ErrorCode.INVALID_MESSAGE_CONTENT, message);
	}
}
