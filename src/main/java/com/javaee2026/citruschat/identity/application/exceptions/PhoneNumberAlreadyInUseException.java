package com.javaee2026.citruschat.identity.application.exceptions;

import com.javaee2026.citruschat.shared.domain.constants.ErrorMessages;
import com.javaee2026.citruschat.shared.domain.errors.ErrorCode;

public class PhoneNumberAlreadyInUseException extends RuntimeException {

    private final ErrorCode errorCode;

    public PhoneNumberAlreadyInUseException() {
        super(ErrorMessages.PHONE_NUMBER_ALREADY_IN_USE);
        this.errorCode = ErrorCode.PHONE_NUMBER_ALREADY_IN_USE;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}