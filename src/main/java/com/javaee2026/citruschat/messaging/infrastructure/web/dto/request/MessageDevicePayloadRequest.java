package com.javaee2026.citruschat.messaging.infrastructure.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record MessageDevicePayloadRequest(

		@NotNull UUID targetDeviceId,

		@NotBlank String encryptedPayload

) {
}
