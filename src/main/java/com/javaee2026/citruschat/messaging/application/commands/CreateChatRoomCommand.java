package com.javaee2026.citruschat.messaging.application.commands;

import com.javaee2026.citruschat.messaging.domain.enums.ChatRoomType;

import java.util.UUID;

public record CreateChatRoomCommand(ChatRoomType chatRoomType, String name, UUID chatRoomCreatorId) {
}
