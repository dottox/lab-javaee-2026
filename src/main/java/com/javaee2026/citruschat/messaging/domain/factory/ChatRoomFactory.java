package com.javaee2026.citruschat.messaging.domain.factory;

import com.javaee2026.citruschat.messaging.domain.enums.ChatRoomType;
import com.javaee2026.citruschat.messaging.domain.model.ChatRoom;
import com.javaee2026.citruschat.shared.domain.valueobjects.ChatRoomId;
import com.javaee2026.citruschat.shared.domain.valueobjects.ParticipantId;
import com.javaee2026.citruschat.shared.domain.valueobjects.UserId;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
public class ChatRoomFactory {

	public ChatRoom createNew(ChatRoomType chatRoomType, String name, UserId creatorId) {
		return new ChatRoom(ChatRoomId.newId(), chatRoomType, name, creatorId, null, Instant.now(), null, null);
	}

	public ChatRoom reconstitute(ChatRoomId chatRoomId, ChatRoomType chatRoomType, String name, UserId creatorId,
			List<ParticipantId> participantIds, Instant createdAt, Instant editedAt, Instant deletedAt) {
		return new ChatRoom(chatRoomId, chatRoomType, name, creatorId, participantIds, createdAt, editedAt, deletedAt);
	}
}
