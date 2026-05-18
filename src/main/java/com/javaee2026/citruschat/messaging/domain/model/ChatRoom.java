package com.javaee2026.citruschat.messaging.domain.model;

import com.javaee2026.citruschat.messaging.domain.enums.ChatRoomType;
import com.javaee2026.citruschat.messaging.domain.exceptions.InvalidMessageException;
import com.javaee2026.citruschat.shared.domain.constants.ErrorMessages;
import com.javaee2026.citruschat.shared.domain.valueobjects.ChatRoomId;
import com.javaee2026.citruschat.shared.domain.valueobjects.ParticipantId;
import com.javaee2026.citruschat.shared.domain.valueobjects.UserId;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.Instant;
import java.util.List;

import static java.util.Objects.requireNonNull;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ChatRoom {

	@EqualsAndHashCode.Include
	private final ChatRoomId id;

	private final ChatRoomType type;
	private final String name;
	private final UserId createdBy;
	private final List<ParticipantId> participantIDList;

	private final Instant createdAt;
	private Instant updatedAt;
	private Instant deletedAt;

	public ChatRoom(ChatRoomId id, ChatRoomType type, String name, UserId createdBy, List<ParticipantId> participantIds,
			Instant createdAt) {
		this(id, type, name, createdBy, participantIds, createdAt, null, null);
	}

	public ChatRoom(ChatRoomId id, ChatRoomType type, String name, UserId createdBy, List<ParticipantId> participantIds,
			Instant createdAt, Instant updatedAt, Instant deletedAt) {
		this.id = requireNonNull(id, ErrorMessages.CHATROOM_ID_CANNOT_BE_NULL);
		this.type = requireNonNull(type, "ChatRoom type cannot be null");
		this.name = requireNonNull(name, "ChatRoom name cannot be null");
		this.createdBy = requireNonNull(createdBy, ErrorMessages.USER_ID_CANNOT_BE_NULL);
		this.participantIDList = participantIds;
		this.createdAt = requireNonNull(createdAt, "Created at cannot be null");
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	public void touch() {
		if (isDeleted()) {
			throw new InvalidMessageException(ErrorMessages.CHATROOM_CANNOT_BE_EDITED);
		}

		this.updatedAt = Instant.now();
	}

	public void delete() {
		if (isDeleted()) {
			throw new InvalidMessageException(ErrorMessages.CHATROOM_ALREADY_DELETED);
		}

		this.deletedAt = Instant.now();
	}

	public void addParticipant(ParticipantId participantId) {
		participantIDList.add(participantId);
	}

	public boolean isDeleted() {
		return deletedAt != null;
	}
}
