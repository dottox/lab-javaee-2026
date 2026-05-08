package com.javaee2026.citruschat.shared.infrastructure.constants;

public final class ApiRoutes {

	private ApiRoutes() {
	}

	private static final String API_BASE = "/api/v1";
	// ===================== BASE API Routes ====================
	private static final String API_ADMIN_BASE = API_BASE + "/admin";
	private static final String API_AUTH_BASE = API_BASE + "/auth";
	// ===================== END BASE API Routes ====================

	// ===================== ADMIN API Routes ====================
	public static final String API_ADMIN_USERS = API_ADMIN_BASE + "/users";
	// ===================== END ADMIN API Routes ====================

	// ===================== AUTH API Routes ====================
	public static final String API_AUTH_VALIDATE_ACCOUNT = API_AUTH_BASE + "/validate-account";
	public static final String API_AUTH_LOGIN = API_AUTH_BASE + "/login";
	// ===================== END API Routes ====================
}
