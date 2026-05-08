package com.javaee2026.citruschat.messaging.infrastructure.persistence.jpa.mapper;

import com.javaee2026.citruschat.messaging.domain.factory.MessageFactory;
import com.javaee2026.citruschat.messaging.domain.model.Message;
import com.javaee2026.citruschat.messaging.infrastructure.persistence.jpa.entity.MessageJpaEntity;
import com.javaee2026.citruschat.shared.domain.valueobjects.ChatRoomId;
import com.javaee2026.citruschat.shared.domain.valueobjects.DeviceId;
import com.javaee2026.citruschat.shared.domain.valueobjects.MessageId;

public class MessageMapper {

	private final MessageFactory messageFactory;

	public MessageMapper(MessageFactory messageFactory) {
		this.messageFactory = messageFactory;
	}

	public Message toDomain(MessageJpaEntity entity) {
		return messageFactory.reconstitute(new MessageId(entity.getId()), new ChatRoomId(entity.getChatRoomId()),
				new DeviceId(entity.getSenderDeviceId()), new MessageId(entity.getReplyToMessageId()),
				entity.getCreatedAt(), entity.getEditedAt(), entity.getDeletedAt());
	}

	public static MessageJpaEntity toJpa(Message message) {
		MessageJpaEntity entity = new MessageJpaEntity();

		entity.setId(message.getId().value());
		entity.setChatRoomId(message.getChatRoomId().value());
		entity.setSenderDeviceId(message.getSenderDeviceId().value());
		entity.setReplyToMessageId(message.getReplyToMessageId().value());

		entity.setCreatedAt(message.getCreatedAt());
		entity.setEditedAt(message.getEditedAt());
		entity.setDeletedAt(message.getDeletedAt());

		return entity;
	}
}
