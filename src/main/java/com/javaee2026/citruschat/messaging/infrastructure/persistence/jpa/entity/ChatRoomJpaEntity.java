package com.javaee2026.citruschat.messaging.infrastructure.persistence.jpa.entity;

import com.javaee2026.citruschat.messaging.domain.enums.ChatRoomType;
import com.javaee2026.citruschat.shared.infrastructure.persistence.constants.TableNames;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = TableNames.Messaging.CHAT_ROOMS)
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

	@Column(nullable = false, name = "participants_ids")
	private List<UUID> participantsIds;

	@Column(nullable = false, name = "created_at")
	private Instant createdAt;

	@Column(name = "updated_at")
	private Instant updatedAt;

	@Column(name = "deleted_at")
	private Instant deletedAt;
}
