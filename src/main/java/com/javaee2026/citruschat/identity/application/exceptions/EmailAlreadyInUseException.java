package com.javaee2026.citruschat.identity.application.exceptions;

import com.javaee2026.citruschat.shared.domain.constants.ErrorMessages;
import com.javaee2026.citruschat.shared.domain.errors.ErrorCode;

public class EmailAlreadyInUseException extends RuntimeException {

    private final ErrorCode errorCode;

    public EmailAlreadyInUseException() {
        super(ErrorMessages.EMAIL_ALREADY_IN_USE);
        this.errorCode = ErrorCode.EMAIL_ALREADY_IN_USE;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}