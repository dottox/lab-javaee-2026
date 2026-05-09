package com.javaee2026.citruschat.messaging.domain.model;

import com.javaee2026.citruschat.shared.domain.valueobjects.DeviceId;
import com.javaee2026.citruschat.shared.domain.valueobjects.MessageId;
import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@Getter
public class MessageDevicePayload {

	private final UUID id;
	private final MessageId messageId;
	private final DeviceId targetDeviceId;
	private final String encryptedPayload;
	// private final String encryptionHeader;
	private final Instant deliveredAt;
	private final Instant readAt;

	public MessageDevicePayload(UUID id, MessageId messageId, DeviceId targetDeviceId, String encryptedPayload,
			// String encryptionHeader,
			Instant deliveredAt, Instant readAt) {
		this.id = id;
		this.messageId = messageId;
		this.targetDeviceId = targetDeviceId;
		this.encryptedPayload = encryptedPayload;
		// this.encryptionHeader = encryptionHeader;
		this.deliveredAt = deliveredAt;
		this.readAt = readAt;
	}
}
