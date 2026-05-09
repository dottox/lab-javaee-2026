package com.javaee2026.citruschat.messaging.infrastructure.persistence.jpa.entity;
import com.javaee2026.citruschat.shared.infrastructure.persistence.constants.TableNames;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Persistable;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = TableNames.Messaging.MESSAGE_DEVICE_PAYLOADS, uniqueConstraints = {
		@UniqueConstraint(columnNames = {"message_id", "target_device_id"})})
@Getter
@Setter
public class MessageDevicePayloadJpaEntity implements Persistable<UUID> {

	@Id
	private UUID id;

	@Column(name = "message_id", nullable = false)
	private UUID messageId;

	@Column(name = "target_device_id", nullable = false)
	private UUID targetDeviceId;

	@Column(name = "encrypted_payload", columnDefinition = "text")
	private String encryptedPayload;

	@Column(name = "encryption_header", columnDefinition = "json", insertable = false, updatable = false)
	private String encryptionHeader;

	@Column(name = "delivered_at")
	private Instant deliveredAt;

	@Column(name = "read_at")
	private Instant readAt;

	@Transient
	private boolean isNew = true;

	@Override
	public UUID getId() {
		return id;
	}

	@Override
	public boolean isNew() {
		return isNew;
	}

	@PostLoad
	@PostPersist
	void markNotNew() {
		this.isNew = false;
	}

}
