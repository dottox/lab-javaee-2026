package com.javaee2026.citruschat.identity.application.commands;

public record RegisterUserCommand(
        String email,
        String username,
        String phoneNumber
) {
}