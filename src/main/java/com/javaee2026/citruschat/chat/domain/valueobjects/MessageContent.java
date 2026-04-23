package com.javaee2026.citruschat.chat.domain.valueobjects;

public class MessageContent {
    private final String value;

    public MessageContent(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Message content cannot be empty");
        }
        if (value.length() > 2000) {
            throw new IllegalArgumentException("Message content is too long");
        }
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MessageContent that)) return false;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}