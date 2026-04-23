package com.javaee2026.citruschat.identity.domain.exceptions;

import com.javaee2026.citruschat.shared.domain.constants.ErrorMessages;

public class UserAlreadyInactiveException extends RuntimeException {

    public UserAlreadyInactiveException() {
        super(ErrorMessages.USER_ALREADY_INACTIVE);
    }
}