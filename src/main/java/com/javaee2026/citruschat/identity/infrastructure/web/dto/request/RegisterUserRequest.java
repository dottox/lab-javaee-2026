package com.javaee2026.citruschat.identity.infrastructure.web.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.aspectj.weaver.ast.Not;

public record RegisterUserRequest(
        @NotBlank @Email String email,
        @NotBlank String phoneNumber,
        @NotBlank String username) {
}