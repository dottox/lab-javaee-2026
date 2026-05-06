package com.javaee2026.citruschat.shared.infrastructure.constants;

public final class ApiRoutes {

    private ApiRoutes() {
    }
    private static final String API_BASE = "/api/v1";
    private static final String ADMIN_BASE = API_BASE + "/admin";
    public static final String API_ADMIN_USERS = ADMIN_BASE + "/users";
}