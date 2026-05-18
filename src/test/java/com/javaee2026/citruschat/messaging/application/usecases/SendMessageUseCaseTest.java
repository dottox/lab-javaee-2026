package com.javaee2026.citruschat.messaging.application.usecases;

import com.javaee2026.citruschat.messaging.application.commands.MessageDevicePayloadCommand;
import com.javaee2026.citruschat.messaging.application.commands.SendMessageCommand;
import com.javaee2026.citruschat.messaging.application.ports.IMessageRepository;
import com.javaee2026.citruschat.messaging.domain.factory.MessageDevicePayloadFactory;
import com.javaee2026.citruschat.messaging.domain.factory.MessageFactory;
import com.javaee2026.citruschat.messaging.domain.model.Message;
import com.javaee2026.citruschat.messaging.domain.model.MessageDevicePayload;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
class SendMessageUseCaseTest {

	private final IMessageRepository messageRepository = mock(IMessageRepository.class);

	private final SendMessageUseCase useCase = new SendMessageUseCase(messageRepository, new MessageFactory(),
			new MessageDevicePayloadFactory());

	@Test
	void shouldSendMessageWithDevicePayloads() {
		UUID chatRoomId = UUID.randomUUID();
		UUID senderDeviceId = UUID.randomUUID();
		UUID targetDeviceId1 = UUID.randomUUID();
		UUID targetDeviceId2 = UUID.randomUUID();

		SendMessageCommand command = new SendMessageCommand(chatRoomId, UUID.randomUUID(), senderDeviceId, null,
				List.of(new MessageDevicePayloadCommand(targetDeviceId1, "encrypted-for-device-1"),
						new MessageDevicePayloadCommand(targetDeviceId2, "encrypted-for-device-2")));

		useCase.execute(command);

		ArgumentCaptor<Message> messageCaptor = ArgumentCaptor.forClass(Message.class);
		ArgumentCaptor<List<MessageDevicePayload>> payloadsCaptor = ArgumentCaptor.forClass(List.class);

		verify(messageRepository).save(messageCaptor.capture(), payloadsCaptor.capture());

		Message message = messageCaptor.getValue();
		List<MessageDevicePayload> payloads = payloadsCaptor.getValue();

		assertNotNull(message.getId());
		assertEquals(chatRoomId, message.getChatRoomId().value());
		assertEquals(senderDeviceId, message.getSenderDeviceId().value());
		assertNull(message.getReplyToMessageId());
		assertNotNull(message.getCreatedAt());

		assertEquals(2, payloads.size());

		assertEquals(message.getId(), payloads.get(0).getMessageId());
		assertEquals(targetDeviceId1, payloads.get(0).getTargetDeviceId().value());
		assertEquals("encrypted-for-device-1", payloads.get(0).getEncryptedPayload());

		assertEquals(message.getId(), payloads.get(1).getMessageId());
		assertEquals(targetDeviceId2, payloads.get(1).getTargetDeviceId().value());
		assertEquals("encrypted-for-device-2", payloads.get(1).getEncryptedPayload());
	}
}
