package com.javaee2026.citruschat.messaging.application.ports;

import com.javaee2026.citruschat.messaging.domain.model.Message;
import com.javaee2026.citruschat.messaging.domain.model.MessageDevicePayload;

import java.util.List;

public interface IMessageRepository {
	void save(Message message, List<MessageDevicePayload> payloads);
}
