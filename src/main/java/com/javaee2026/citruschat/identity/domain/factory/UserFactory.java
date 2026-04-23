package com.javaee2026.citruschat.identity.domain.factory;

import com.javaee2026.citruschat.identity.domain.model.User;
import com.javaee2026.citruschat.identity.domain.valueobjects.PhoneNumber;
import com.javaee2026.citruschat.identity.domain.valueobjects.UserEmail;
import com.javaee2026.citruschat.identity.domain.valueobjects.Username;
import com.javaee2026.citruschat.shared.domain.valueobjects.UserId;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class UserFactory {

    public User createNew(
            UserEmail email,
            Username username,
            PhoneNumber phoneNumber,
            String passwordHash
    ) {
        Instant now = Instant.now();

        return new User(
                UserId.newId(),
                email,
                username,
                phoneNumber,
                passwordHash,
                now,
                now,
                null
        );
    }

    //reconstitute = reconstruir desde la base de datos
    //Es el método que usás cuando ya existe el objeto y lo estás trayendo desde persistencia.
    public User reconstitute(
            UserId id,
            UserEmail email,
            Username username,
            PhoneNumber phoneNumber,
            String passwordHash,
            Instant createdAt,
            Instant updatedAt,
            Instant deletedAt
    ) {
        return new User(
                id,
                email,
                username,
                phoneNumber,
                passwordHash,
                createdAt,
                updatedAt,
                deletedAt
        );
    }
}