package com.javaee2026.citruschat.messaging.infrastructure.persistence.entities;

import com.javaee2026.citruschat.messaging.domain.enums.ChatRoomType;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "chat_rooms")
public class ChatRoomJpaEntity {

	@Id
	private UUID id;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ChatRoomType type;

	@Column(name = "name")
	private String name;

	@Column(name = "avatar_url")
	private String avatarUrl;

	@Column(nullable = false, name = "created_by")
	private UUID createdBy;

	@Column(nullable = false, name = "created_at")
	private Instant createdAt;

	@Column(name = "updated_at")
	private Instant updatedAt;

	@Column(name = "deleted_at")
	private Instant deletedAt;

	protected ChatRoomJpaEntity() {
	}
}
