package com.javaee2026.citruschat.messaging.infrastructure.persistence.jpa.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.javaee2026.citruschat.messaging.infrastructure.persistence.jpa.entity.ChatRoomJpaEntity;

public interface SpringDataChatRoomRepository extends JpaRepository<ChatRoomJpaEntity, UUID> {
}
