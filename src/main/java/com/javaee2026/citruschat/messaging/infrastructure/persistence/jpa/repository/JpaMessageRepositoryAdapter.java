package com.javaee2026.citruschat.messaging.infrastructure.persistence.jpa.repository;

import com.javaee2026.citruschat.messaging.application.ports.IMessageRepository;
import com.javaee2026.citruschat.messaging.domain.model.Message;
import com.javaee2026.citruschat.messaging.domain.model.MessageDevicePayload;
import com.javaee2026.citruschat.messaging.infrastructure.persistence.jpa.mapper.MessageDevicePayloadMapper;
import com.javaee2026.citruschat.messaging.infrastructure.persistence.jpa.mapper.MessageMapper;
import jakarta.transaction.Transactional;

import java.util.List;

public class JpaMessageRepositoryAdapter implements IMessageRepository {

	private final SpringDataMessageRepository messageRepository;
	private final SpringDataMessageDevicePayloadRepository payloadRepository;
	private final MessageMapper messageMapper;

	public JpaMessageRepositoryAdapter(SpringDataMessageRepository messageRepository,
			SpringDataMessageDevicePayloadRepository payloadRepository, MessageMapper messageMapper) {
		this.messageRepository = messageRepository;
		this.payloadRepository = payloadRepository;
		this.messageMapper = messageMapper;
	}

	@Override
	@Transactional
	public void save(Message message, List<MessageDevicePayload> payloads) {

		messageRepository.save(MessageMapper.toJpa(message));

		payloadRepository.saveAll(payloads.stream().map(MessageDevicePayloadMapper::toJpa).toList());
	}
}
