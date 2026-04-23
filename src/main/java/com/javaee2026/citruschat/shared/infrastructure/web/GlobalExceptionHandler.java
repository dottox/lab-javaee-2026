package com.javaee2026.citruschat.shared.infrastructure.web;

import com.javaee2026.citruschat.identity.application.exceptions.EmailAlreadyInUseException;
import com.javaee2026.citruschat.identity.application.exceptions.PhoneNumberAlreadyInUseException;
import com.javaee2026.citruschat.identity.application.exceptions.UsernameAlreadyInUseException;
import com.javaee2026.citruschat.identity.domain.exceptions.UserAlreadyActiveException;
import com.javaee2026.citruschat.identity.domain.exceptions.UserAlreadyInactiveException;
import com.javaee2026.citruschat.shared.domain.constants.ErrorMessages;
import com.javaee2026.citruschat.shared.domain.errors.ErrorCode;
import com.javaee2026.citruschat.shared.infrastructure.web.dto.ApiErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyInUseException.class)
    public ResponseEntity<ApiErrorResponse> handleEmailAlreadyInUse(
            EmailAlreadyInUseException ex,
            HttpServletRequest request
    ) {
        return buildErrorResponse(
                HttpStatus.CONFLICT,
                ex.getErrorCode(),
                ex.getMessage(),
                request
        );
    }

    @ExceptionHandler(UsernameAlreadyInUseException.class)
    public ResponseEntity<ApiErrorResponse> handleUsernameAlreadyInUse(
            UsernameAlreadyInUseException ex,
            HttpServletRequest request
    ) {
        return buildErrorResponse(
                HttpStatus.CONFLICT,
                ex.getErrorCode(),
                ex.getMessage(),
                request
        );
    }

    @ExceptionHandler(PhoneNumberAlreadyInUseException.class)
    public ResponseEntity<ApiErrorResponse> handlePhoneNumberAlreadyInUse(
            PhoneNumberAlreadyInUseException ex,
            HttpServletRequest request
    ) {
        return buildErrorResponse(
                HttpStatus.CONFLICT,
                ex.getErrorCode(),
                ex.getMessage(),
                request
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiErrorResponse> handleIllegalArgumentException(
            IllegalArgumentException ex,
            HttpServletRequest request
    ) {
        return buildErrorResponse(
                HttpStatus.BAD_REQUEST,
                ErrorCode.UNEXPECTED_ERROR,
                ex.getMessage(),
                request
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleGenericException(
            Exception ex,
            HttpServletRequest request
    ) {
        return buildErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ErrorCode.UNEXPECTED_ERROR,
                ErrorMessages.UNEXPECTED_ERROR,
                request
        );
    }

    private ResponseEntity<ApiErrorResponse> buildErrorResponse(
            HttpStatus status,
            ErrorCode errorCode,
            String message,
            HttpServletRequest request
    ) {
        ApiErrorResponse error = new ApiErrorResponse(
                Instant.now(),
                status.value(),
                status.getReasonPhrase(),
                errorCode.name(),
                message,
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(UserAlreadyInactiveException.class)
    public ResponseEntity<ApiErrorResponse> handleUserAlreadyInactive(
            UserAlreadyInactiveException ex,
            HttpServletRequest request
    ) {
        return buildErrorResponse(
                HttpStatus.CONFLICT,
                ErrorCode.USER_ALREADY_INACTIVE,
                ex.getMessage(),
                request
        );
    }

    @ExceptionHandler(UserAlreadyActiveException.class)
    public ResponseEntity<ApiErrorResponse> handleUserAlreadyInactive(
            UserAlreadyActiveException ex,
            HttpServletRequest request
    ) {
        return buildErrorResponse(
                HttpStatus.CONFLICT,
                ErrorCode.USER_ALREADY_ACTIVE,
                ex.getMessage(),
                request
        );
    }
}