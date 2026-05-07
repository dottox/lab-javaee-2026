package com.javaee2026.citruschat.identity.domain.valueobjects;

import com.javaee2026.citruschat.identity.domain.exceptions.InvalidEmailException;
import com.javaee2026.citruschat.shared.domain.constants.ErrorMessages;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.regex.Pattern;

@ToString
@EqualsAndHashCode
@Getter
public final class UserEmail {

	private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
	private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

	private final String value;

	public UserEmail(String email) {
		if (email == null) {
			throw new InvalidEmailException(ErrorMessages.EMAIL_CANNOT_BE_NULL);
		}

		String normalized = email.trim().toLowerCase();

		if (!EMAIL_PATTERN.matcher(normalized).matches()) {
			throw new InvalidEmailException(ErrorMessages.INVALID_EMAIL_FORMAT);
		}

		this.value = normalized;
	}
}
