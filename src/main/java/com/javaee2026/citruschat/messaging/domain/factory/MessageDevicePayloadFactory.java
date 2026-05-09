package com.javaee2026.citruschat.messaging.domain.factory;

import com.javaee2026.citruschat.messaging.domain.model.MessageDevicePayload;
import com.javaee2026.citruschat.shared.domain.valueobjects.DeviceId;
import com.javaee2026.citruschat.shared.domain.valueobjects.MessageId;

import java.util.UUID;

public class MessageDevicePayloadFactory {

	public MessageDevicePayload create(MessageId messageId, DeviceId targetDeviceId, String encryptedPayload
	// String encryptionHeader
	) {
		return new MessageDevicePayload(UUID.randomUUID(), messageId, targetDeviceId, encryptedPayload,
				// encryptionHeader,
				null, null);
	}

	public MessageDevicePayload reconstitute(UUID id, MessageId messageId, DeviceId targetDeviceId,
			String encryptedPayload, String encryptionHeader, java.time.Instant deliveredAt, java.time.Instant readAt) {
		return new MessageDevicePayload(id, messageId, targetDeviceId, encryptedPayload,
				// encryptionHeader,
				deliveredAt, readAt);
	}
}
