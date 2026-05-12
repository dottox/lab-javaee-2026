package com.javaee2026.citruschat.messaging.application.ports;

import com.javaee2026.citruschat.messaging.domain.model.ChatRoom;

public interface IChatRoomRepository {
	void save(ChatRoom chatRoom);
}
