package com.javaee2026.citruschat.messaging.infrastructure.persistence.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "chat_participants")
public class ChatParticipantJpaEntity {

	@Id
	@Column(name = "id", nullable = false, updatable = false)
	private UUID id;

	@Column(name = "chat_room_id", nullable = false)
	private UUID chatRoomId;

	@Column(name = "user_id", nullable = false)
	private UUID userId;

	@Column(name = "role_id", nullable = false)
	private UUID roleId;

	@Column(name = "joined_at", nullable = false)
	private Instant joinedAt;

	@Column(name = "left_at")
	private Instant leftAt;

	@Column(name = "last_read_message_id")
	private UUID lastReadMessageId;
}
