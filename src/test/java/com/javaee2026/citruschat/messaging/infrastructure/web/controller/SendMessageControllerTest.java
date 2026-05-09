package com.javaee2026.citruschat.messaging.infrastructure.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaee2026.citruschat.messaging.application.usecases.SendMessageUseCase;
import com.javaee2026.citruschat.shared.domain.constants.ApiResponseMessages;
import com.javaee2026.citruschat.shared.infrastructure.constants.ApiRoutes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SendMessageController.class)
class SendMessageControllerTest {

	@Autowired
	private MockMvc mockMvc;

	private final ObjectMapper objectMapper = new ObjectMapper();

	@MockitoBean
	private SendMessageUseCase sendMessageUseCase;

	@Test
	void shouldSendMessage() throws Exception {
		Jwt jwt = Jwt.withTokenValue("access-token").header("alg", "HS256")
				.subject("91ae5825-9096-4c74-9447-1bf03004c36b").claim("email", "test@gmail.com")
				.claim("username", "test_user").issuedAt(Instant.now()).expiresAt(Instant.now().plusSeconds(3600))
				.build();

		Map<String, Object> body = Map.of("chatRoomId", "11111111-1111-1111-1111-111111111111", "senderDeviceId",
				"22222222-2222-2222-2222-222222222222", "payloads",
				java.util.List.of(
						Map.of("targetDeviceId", "33333333-3333-3333-3333-333333333333", "encryptedPayload",
								"encrypted-for-device-1"),
						Map.of("targetDeviceId", "44444444-4444-4444-4444-444444444444", "encryptedPayload",
								"encrypted-for-device-2")));
		mockMvc.perform(post(ApiRoutes.API_MESSAGES).with(jwt().jwt(jwt)).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(body))).andExpect(status().isCreated())
				.andExpect(jsonPath("$.success", is(true)))
				.andExpect(jsonPath("$.message", is(ApiResponseMessages.MESSAGE_SENT_SUCCESS)))
				.andExpect(jsonPath("$.data.sent", is(true)));

		verify(sendMessageUseCase).execute(any());
	}
}
