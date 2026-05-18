package com.javaee2026.citruschat.messaging.infrastructure.persistence.jpa.mapper;

import com.javaee2026.citruschat.messaging.domain.factory.ChatParticipantFactory;
import com.javaee2026.citruschat.messaging.domain.model.ChatParticipant;
import com.javaee2026.citruschat.messaging.infrastructure.persistence.jpa.entity.ChatParticipantJpaEntity;
import com.javaee2026.citruschat.shared.domain.valueobjects.*;

public final class ChatParticipantMapper {
	private final ChatParticipantFactory chatParticipantFactory;

	public ChatParticipantMapper(ChatParticipantFactory chatParticipantFactory) {
		this.chatParticipantFactory = chatParticipantFactory;
	}

	public ChatParticipant toDomain(ChatParticipantJpaEntity entity) {
		return chatParticipantFactory.reconstitute(new ParticipantId(entity.getId()),
				new ChatRoomId(entity.getChatRoomId()), new UserId(entity.getUserId()), new RoleId(entity.getRoleId()),
				entity.getJoinedAt(), entity.getLeftAt(), new MessageId(entity.getLastReadMessageId()));
	}

	public static ChatParticipantJpaEntity toJpa(ChatParticipant chatParticipant) {
		ChatParticipantJpaEntity entity = new ChatParticipantJpaEntity();

		entity.setId(chatParticipant.getId().value());
		entity.setChatRoomId(chatParticipant.getChatRoomId().value());
		entity.setUserId(chatParticipant.getUserId().value());
		entity.setRoleId(chatParticipant.getRoleId().value());

		entity.setJoinedAt(chatParticipant.getJoinedAt());
		entity.setLeftAt(chatParticipant.getLeftAt());
		entity.setLastReadMessageId(chatParticipant.getLastReadMessageId().value());

		return entity;
	}
}
