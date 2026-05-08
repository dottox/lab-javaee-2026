package com.javaee2026.citruschat.identity.infrastructure.web.mapper;

import com.javaee2026.citruschat.identity.infrastructure.web.dto.response.CurrentUserResponse;
import org.springframework.security.oauth2.jwt.Jwt;

public final class CurrentUserWebMapper {

	private CurrentUserWebMapper() {
	}

	public static CurrentUserResponse toResponse(Jwt jwt) {
		return new CurrentUserResponse(jwt.getSubject(), jwt.getClaimAsString("email"),
				jwt.getClaimAsString("username"));
	}
}
