package com.javaee2026.citruschat.messaging.infrastructure.persistence.jpa.mapper;

import com.javaee2026.citruschat.messaging.domain.factory.ChatRoomFactory;
import com.javaee2026.citruschat.messaging.domain.model.ChatRoom;
import com.javaee2026.citruschat.messaging.infrastructure.persistence.jpa.entity.ChatRoomJpaEntity;
import com.javaee2026.citruschat.shared.domain.valueobjects.ChatRoomId;
import com.javaee2026.citruschat.shared.domain.valueobjects.UserId;

public final class ChatRoomMapper {

	private final ChatRoomFactory chatRoomFactory;

	public ChatRoomMapper(ChatRoomFactory chatRoomFactory) {
		this.chatRoomFactory = chatRoomFactory;
	}

	public ChatRoom toDomain(ChatRoomJpaEntity entity) {
		return chatRoomFactory.reconstitute(new ChatRoomId(entity.getId()), entity.getType(), entity.getName(),
				new UserId(entity.getCreatedBy()), entity.getCreatedAt(), entity.getUpdatedAt(), entity.getDeletedAt());
	}

	public static ChatRoomJpaEntity toJpa(ChatRoom chatRoom) {
		ChatRoomJpaEntity entity = new ChatRoomJpaEntity();

		entity.setId(chatRoom.getId().value());
		entity.setType(chatRoom.getType());
		entity.setName(chatRoom.getName());
		entity.setCreatedBy(chatRoom.getCreatedBy().value());

		entity.setCreatedAt(chatRoom.getCreatedAt());
		entity.setUpdatedAt(chatRoom.getUpdatedAt());
		entity.setDeletedAt(chatRoom.getDeletedAt());

		return entity;
	}
}
