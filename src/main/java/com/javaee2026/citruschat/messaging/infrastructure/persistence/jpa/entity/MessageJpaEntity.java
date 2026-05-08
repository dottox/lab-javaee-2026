package com.javaee2026.citruschat.messaging.infrastructure.persistence.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "messages")
@Getter
@Setter
public class MessageJpaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(name = "chat_room_id", nullable = false)
	private UUID chatRoomId;

	@Column(name = "sender_device_id", nullable = false)
	private UUID senderDeviceId;

	@Column(name = "reply_to_message_id")
	private UUID replyToMessageId;

	@Column(name = "created_at", nullable = false)
	private Instant createdAt;

	@Column(name = "edited_at")
	private Instant editedAt;

	@Column(name = "deleted_at")
	private Instant deletedAt;
}
