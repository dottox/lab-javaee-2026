package com.javaee2026.citruschat.chat.domain.valueobjects;

import com.javaee2026.citruschat.chat.domain.exceptions.InvalidMessageContentException;
import com.javaee2026.citruschat.shared.domain.constants.ErrorMessages;

public class MessageContent {

	private static final int MAX_LENGTH = 2000;

	private final String value;

	public MessageContent(String value) {
		if (value == null || value.isBlank()) {
			throw new InvalidMessageContentException(ErrorMessages.MESSAGE_CONTENT_CANNOT_BE_EMPTY);
		}

		if (value.length() > MAX_LENGTH) {
			throw new InvalidMessageContentException(ErrorMessages.MESSAGE_CONTENT_TOO_LONG(MAX_LENGTH));
		}

		this.value = value;
	}

	public String value() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof MessageContent that))
			return false;
		return value.equals(that.value);
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}
}
