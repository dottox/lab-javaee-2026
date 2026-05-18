package com.javaee2026.citruschat.identity.application.usecases;

import com.javaee2026.citruschat.identity.application.ports.IAdminAccessRepository;

import java.util.UUID;

public class CheckAdminAccessUseCase {

	private final IAdminAccessRepository repository;

	public CheckAdminAccessUseCase(IAdminAccessRepository repository) {
		this.repository = repository;
	}

	public boolean execute(UUID userId) {

		if (userId == null) {
			return false;
		}

		return repository.userHasAdminAccess(userId);
	}
}
