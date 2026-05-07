package com.javaee2026.citruschat.identity.application.commands;

public record ValidateUserAccountCommand(String username, String temporaryPassword, String newPassword) {
}
