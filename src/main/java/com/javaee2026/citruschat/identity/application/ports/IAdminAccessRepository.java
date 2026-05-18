package com.javaee2026.citruschat.identity.application.ports;

import java.util.UUID;

public interface IAdminAccessRepository {

	boolean userHasAdminAccess(UUID userId);
}
