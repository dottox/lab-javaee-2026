package com.javaee2026.citruschat.messaging.infrastructure.web.dto.response;

import java.util.UUID;

public record DevicePayloadResponse(

		UUID targetDeviceId,

		String encryptedPayload

) {
}
