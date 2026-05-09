package com.javaee2026.citruschat.messaging.infrastructure.persistence.jpa.mapper;

import com.javaee2026.citruschat.messaging.domain.model.MessageDevicePayload;
import com.javaee2026.citruschat.messaging.infrastructure.persistence.jpa.entity.MessageDevicePayloadJpaEntity;
import com.javaee2026.citruschat.shared.domain.valueobjects.DeviceId;
import com.javaee2026.citruschat.shared.domain.valueobjects.MessageId;

public final class MessageDevicePayloadMapper {

	private MessageDevicePayloadMapper() {
	}

	public static MessageDevicePayloadJpaEntity toJpa(MessageDevicePayload payload) {
		MessageDevicePayloadJpaEntity entity = new MessageDevicePayloadJpaEntity();

		entity.setId(payload.getId());
		entity.setMessageId(payload.getMessageId().value());
		entity.setTargetDeviceId(payload.getTargetDeviceId().value());
		entity.setEncryptedPayload(payload.getEncryptedPayload());
		// entity.setEncryptionHeader(payload.getEncryptionHeader());
		entity.setDeliveredAt(payload.getDeliveredAt());
		entity.setReadAt(payload.getReadAt());

		return entity;
	}

	public static MessageDevicePayload toDomain(MessageDevicePayloadJpaEntity entity) {
		return new MessageDevicePayload(entity.getId(), new MessageId(entity.getMessageId()),
				new DeviceId(entity.getTargetDeviceId()), entity.getEncryptedPayload(),
				// entity.getEncryptionHeader(),
				entity.getDeliveredAt(), entity.getReadAt());
	}
}
