package com.javaee2026.citruschat.messaging.infrastructure.configuration;

import com.javaee2026.citruschat.messaging.application.ports.IMessageRepository;
import com.javaee2026.citruschat.messaging.application.usecases.SendMessageUseCase;
import com.javaee2026.citruschat.messaging.domain.factory.MessageDevicePayloadFactory;
import com.javaee2026.citruschat.messaging.domain.factory.MessageFactory;
import com.javaee2026.citruschat.messaging.infrastructure.persistence.jpa.mapper.MessageMapper;
import com.javaee2026.citruschat.messaging.infrastructure.persistence.jpa.repository.JpaMessageRepositoryAdapter;
import com.javaee2026.citruschat.messaging.infrastructure.persistence.jpa.repository.SpringDataMessageDevicePayloadRepository;
import com.javaee2026.citruschat.messaging.infrastructure.persistence.jpa.repository.SpringDataMessageRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingBeansConfiguration {

	@Bean
	public MessageFactory messageFactory() {
		return new MessageFactory();
	}

	@Bean
	public MessageDevicePayloadFactory messageDevicePayloadFactory() {
		return new MessageDevicePayloadFactory();
	}

	@Bean
	public MessageMapper messageMapper(MessageFactory messageFactory) {
		return new MessageMapper(messageFactory);
	}

	@Bean
	public IMessageRepository messageRepository(SpringDataMessageRepository messageRepository,
			SpringDataMessageDevicePayloadRepository payloadRepository, MessageMapper messageMapper) {
		return new JpaMessageRepositoryAdapter(messageRepository, payloadRepository, messageMapper);
	}

	@Bean
	public SendMessageUseCase sendMessageUseCase(MessageFactory messageFactory, IMessageRepository messageRepository,
			MessageDevicePayloadFactory payloadFactory) {
		return new SendMessageUseCase(messageRepository, messageFactory, payloadFactory);
	}
}
