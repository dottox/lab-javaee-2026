package com.javaee2026.citruschat.messaging.domain.factory;

import com.javaee2026.citruschat.messaging.domain.model.Message;
import com.javaee2026.citruschat.shared.domain.valueobjects.ChatRoomId;
import com.javaee2026.citruschat.shared.domain.valueobjects.DeviceId;
import com.javaee2026.citruschat.shared.domain.valueobjects.MessageId;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class MessageFactory {

	public Message createNew(ChatRoomId chatRoomId, DeviceId senderDeviceId, MessageId replyToMessageId) {

		return new Message(MessageId.newId(), chatRoomId, senderDeviceId, replyToMessageId, Instant.now(), null, null);
	}

	public Message reconstitute(MessageId id, ChatRoomId chatRoomId, DeviceId senderDeviceId,
			MessageId replyToMessageId, Instant createdAt, Instant editedAt, Instant deletedAt) {
		return new Message(id, chatRoomId, senderDeviceId, replyToMessageId, createdAt, editedAt, deletedAt);
	}
}
