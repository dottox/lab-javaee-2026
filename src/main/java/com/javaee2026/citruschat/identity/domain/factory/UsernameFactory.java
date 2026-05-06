package com.javaee2026.citruschat.identity.domain.factory;

import com.javaee2026.citruschat.identity.domain.valueobjects.Username;

import java.text.Normalizer;

public class UsernameFactory {

	private static final int MAX_USERNAME_LENGTH = 20;

	public Username create(String firstName, String lastName) {

		String sanitizedFirstName = firstName.trim();
		String sanitizedLastName = lastName.trim();

		String raw = sanitizedFirstName + "_" + sanitizedLastName;

		String normalized = Normalizer.normalize(raw, Normalizer.Form.NFD).replaceAll("\\p{M}", "").toLowerCase()
				.replaceAll("\\s+", "_").replaceAll("_+", "_").replaceAll("^_+", "").replaceAll("_+$", "");

		normalized = truncate(normalized);

		return new Username(normalized);
	}

	private String truncate(String username) {

		if (username.length() <= MAX_USERNAME_LENGTH) {
			return username;
		}

		return username.substring(0, MAX_USERNAME_LENGTH);
	}
}
