package com.javaee2026.citruschat.identity.infrastructure.web.controller;

import com.javaee2026.citruschat.shared.domain.constants.ApiResponseMessages;
import com.javaee2026.citruschat.shared.infrastructure.constants.ApiRoutes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;

import static org.hamcrest.Matchers.is;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc
class CurrentUserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void shouldReturnCurrentAuthenticatedUser() throws Exception {
		Jwt jwt = Jwt.withTokenValue("access-token").header("alg", "HS256")
				.subject("91ae5825-9096-4c74-9447-1bf03004c36b").claim("email", "test@gmail.com")
				.claim("username", "test_user").issuedAt(Instant.now()).expiresAt(Instant.now().plusSeconds(3600))
				.build();

		mockMvc.perform(get(ApiRoutes.API_AUTH_ME).with(jwt().jwt(jwt))).andExpect(status().isOk())
				.andExpect(jsonPath("$.success", is(true)))
				.andExpect(jsonPath("$.message", is(ApiResponseMessages.CURRENT_USER_SUCCESS)))
				.andExpect(jsonPath("$.data.userId", is("91ae5825-9096-4c74-9447-1bf03004c36b")))
				.andExpect(jsonPath("$.data.email", is("test@gmail.com")))
				.andExpect(jsonPath("$.data.username", is("test_user")));
	}
}
