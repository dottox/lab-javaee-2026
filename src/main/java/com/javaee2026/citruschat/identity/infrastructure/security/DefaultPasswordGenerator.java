package com.javaee2026.citruschat.identity.infrastructure.security;

import com.javaee2026.citruschat.identity.application.ports.IDefaultPasswordGenerator;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DefaultPasswordGenerator implements IDefaultPasswordGenerator {

    @Override
    public String generate() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}