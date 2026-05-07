package com.javaee2026.citruschat.identity.domain.valueobjects;

import com.javaee2026.citruschat.identity.domain.exceptions.InvalidPersonNameException;
import com.javaee2026.citruschat.shared.domain.constants.ErrorMessages;

public final class PersonName {

	private final String value;

	public PersonName(String value) {
		if (value == null || value.isBlank()) {
			throw new InvalidPersonNameException(ErrorMessages.NAME_CANNOT_BE_EMPTY);
		}

		this.value = value.trim();
	}

	public String value() {
		return value;
	}
}
