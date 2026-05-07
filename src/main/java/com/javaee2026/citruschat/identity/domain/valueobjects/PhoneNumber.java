package com.javaee2026.citruschat.identity.domain.valueobjects;

import com.javaee2026.citruschat.identity.domain.exceptions.InvalidPhoneNumberException;
import com.javaee2026.citruschat.shared.domain.constants.ErrorMessages;
import lombok.Getter;

@Getter
public final class PhoneNumber {

	private static final String NORMALIZE_REGEX = "[\\s\\-()]";
	private static final String PHONE_REGEX = "^\\+?[0-9]{8,15}$";

	private final String value;

	public PhoneNumber(String raw) {
		if (raw == null) {
			throw new InvalidPhoneNumberException(ErrorMessages.PHONE_NUMBER_CANNOT_BE_NULL);
		}

		String normalized = raw.replaceAll(NORMALIZE_REGEX, "");

		if (!normalized.matches(PHONE_REGEX)) {
			throw new InvalidPhoneNumberException(ErrorMessages.INVALID_PHONE_NUMBER_FORMAT);
		}

		this.value = normalized;
	}
}
