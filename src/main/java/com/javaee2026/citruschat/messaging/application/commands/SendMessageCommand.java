package com.javaee2026.citruschat.messaging.application.commands;

import java.util.List;
import java.util.UUID;

public record SendMessageCommand(UUID chatRoomId, UUID senderUserId, UUID senderDeviceId, UUID replyToMessageId,
		List<MessageDevicePayloadCommand> payloads) {
}
