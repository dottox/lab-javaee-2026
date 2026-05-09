package com.javaee2026.citruschat.messaging.application.commands;

import java.util.UUID;

public record MessageDevicePayloadCommand(

		UUID targetDeviceId,

		String encryptedPayload

) {
}
