package com.javaee2026.citruschat.identity.domain.factory;

import com.javaee2026.citruschat.identity.domain.valueobjects.Username;

import java.text.Normalizer;

public class UsernameFactory {

    public Username create(String firstName, String lastName) {

        String raw = firstName + "_" + lastName;

        String normalized = Normalizer.normalize(raw, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .trim()
                .toLowerCase()
                .replaceAll("\\s+", "_");

        return new Username(normalized);
    }
}