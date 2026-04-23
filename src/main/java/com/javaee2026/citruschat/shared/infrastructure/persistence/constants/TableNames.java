package com.javaee2026.citruschat.shared.infrastructure.persistence.constants;

public final class TableNames {

    private TableNames() {}

    public static final class Identity {
        public static final String USERS = "users";
    }

    public static final class Chat {
        public static final String MESSAGES = "messages";
        public static final String CHAT_ROOMS = "chat_rooms";
    }
}