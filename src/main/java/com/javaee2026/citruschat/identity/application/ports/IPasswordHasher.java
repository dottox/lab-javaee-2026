package com.javaee2026.citruschat.identity.application.ports;

public interface IPasswordHasher {
    String hash(String rawPassword);
}