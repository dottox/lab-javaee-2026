package com.javaee2026.citruschat.messaging.infrastructure.web.dto.request;

import com.javaee2026.citruschat.messaging.domain.enums.ChatRoomType;
import jakarta.validation.constraints.NotNull;

public record CreateChatRoomRequest(@NotNull ChatRoomType chatRoomType,

		String name) {
}
