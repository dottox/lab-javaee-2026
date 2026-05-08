package com.javaee2026.citruschat.shared.domain.valueobjects;

import com.javaee2026.citruschat.identity.domain.exceptions.InvalidUserException;
import com.javaee2026.citruschat.shared.domain.constants.ErrorMessages;

import java.util.UUID;

public class DeviceId {

	private final UUID value;

	public DeviceId(UUID value) {
		if (value == null) {
			throw new InvalidUserException(ErrorMessages.DEVICE_ID_CANNOT_BE_NULL);
		}
		this.value = value;
	}

	public static DeviceId newId() {
		return new DeviceId(UUID.randomUUID());
	}

	public UUID value() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof DeviceId deviceId))
			return false;
		return value.equals(deviceId.value);
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}
}
