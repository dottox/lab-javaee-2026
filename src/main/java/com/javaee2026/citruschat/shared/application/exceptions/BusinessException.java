package com.javaee2026.citruschat.shared.application.exceptions;

import com.javaee2026.citruschat.shared.domain.errors.ErrorCode;
import lombok.Getter;

@Getter
public abstract class BusinessException extends RuntimeException {

	private final ErrorCode errorCode;

	protected BusinessException(ErrorCode errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	protected BusinessException(ErrorCode errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

}
