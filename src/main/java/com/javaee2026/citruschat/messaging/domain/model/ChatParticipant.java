package com.javaee2026.citruschat.messaging.domain.model;

import com.javaee2026.citruschat.shared.domain.constants.ErrorMessages;
import com.javaee2026.citruschat.shared.domain.valueobjects.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.Instant;

import static java.util.Objects.requireNonNull;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ChatParticipant {

	@EqualsAndHashCode.Include
	private final ParticipantId id;

	private final ChatRoomId chatRoomId;
	private final UserId userId;
	private final RoleId roleId;

	private final Instant joinedAt;
	private final Instant leftAt;
	private final MessageId lastReadMessageId;

	public ChatParticipant(ParticipantId id, ChatRoomId chatRoomId, UserId userId, RoleId roleId, Instant joinedAt) {
		this(id, chatRoomId, userId, roleId, joinedAt, null, null);
	}

	public ChatParticipant(ParticipantId id, ChatRoomId chatRoomId, UserId userId, RoleId roleId, Instant joinedAt,
			Instant leftAt, MessageId lastReadMessageId) {
		this.id = requireNonNull(id, ErrorMessages.PARTICIPANT_ID_CANNOT_BE_NULL);
		this.chatRoomId = requireNonNull(chatRoomId, ErrorMessages.CHATROOM_ID_CANNOT_BE_NULL);
		this.userId = requireNonNull(userId, ErrorMessages.USER_ID_CANNOT_BE_NULL);
		this.roleId = requireNonNull(roleId, ErrorMessages.ROLE_ID_CANNOT_BE_NULL);
		this.joinedAt = requireNonNull(joinedAt, "joinedAt cannot be null");
		this.leftAt = leftAt;
		this.lastReadMessageId = lastReadMessageId;
	}

}
