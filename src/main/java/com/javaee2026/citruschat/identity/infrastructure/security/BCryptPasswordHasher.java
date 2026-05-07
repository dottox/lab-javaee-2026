package com.javaee2026.citruschat.identity.infrastructure.security;

import com.javaee2026.citruschat.identity.application.ports.IPasswordHasher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptPasswordHasher implements IPasswordHasher {

	private final PasswordEncoder passwordEncoder;

	public BCryptPasswordHasher(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public String hash(String rawPassword) {
		return passwordEncoder.encode(rawPassword);
	}

	@Override
	public boolean matches(final String rawPassword, final String hashedPassword) {
		return passwordEncoder.matches(rawPassword, hashedPassword);
	}
}
