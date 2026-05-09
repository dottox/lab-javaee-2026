package com.javaee2026.citruschat.messaging.application.results;

import com.javaee2026.citruschat.messaging.domain.model.Message;
import com.javaee2026.citruschat.messaging.domain.model.MessageDevicePayload;

import java.util.List;

public record SendMessageResult(Message message, List<MessageDevicePayload> payloads) {
}
