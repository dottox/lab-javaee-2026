package com.javaee2026.citruschat.identity.infrastructure.persistence.jpa.repository;

import com.javaee2026.citruschat.identity.application.ports.IAdminAccessRepository;
import com.javaee2026.citruschat.identity.domain.constants.AdminAccessPolicy;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class JpaAdminAccessRepositoryAdapter implements IAdminAccessRepository {

	private final SpringDataUserOrganizationRepository repository;

	public JpaAdminAccessRepositoryAdapter(SpringDataUserOrganizationRepository repository) {
		this.repository = repository;
	}

	@Override
	public boolean userHasAdminAccess(UUID userId) {

		return repository.existsAdminAccessByUserId(userId, AdminAccessPolicy.ADMIN_POSITION_NAME,
				AdminAccessPolicy.ADMIN_HIERARCHY_LEVEL);
	}
}
