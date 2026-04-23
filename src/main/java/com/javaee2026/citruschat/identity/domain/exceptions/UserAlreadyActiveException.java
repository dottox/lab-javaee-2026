package com.javaee2026.citruschat.identity.domain.exceptions;

import com.javaee2026.citruschat.shared.domain.constants.ErrorMessages;

public class UserAlreadyActiveException extends RuntimeException {

    public UserAlreadyActiveException() {
        super(ErrorMessages.USER_ALREADY_ACTIVE);
    }
}