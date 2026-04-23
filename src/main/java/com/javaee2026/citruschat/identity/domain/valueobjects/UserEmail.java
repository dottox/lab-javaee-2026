package com.javaee2026.citruschat.identity.domain.valueobjects;

import com.javaee2026.citruschat.shared.domain.constants.ErrorMessages;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.regex.Pattern;

/*
Esto es un Value Object. es decir: es un objeto que representa un valor, en este caso el email de un usuario.
Aca valido por ej: que el email no sea null, que tenga un formato valido, etc. Si el email no es valido, lanzo una excepcion.
Asi no meto toda esa logica en el User, que es la entidad. El User solo se preocupa por su identidad (UserId)
y sus atributos (email, passwordHash, etc), pero no se preocupa por validar esos atributos.
Eso lo hace el UserEmail, que es un Value Object.
*/
@ToString
@EqualsAndHashCode
@Getter
public final class UserEmail {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    private final String value;

    public UserEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException(ErrorMessages.EMAIL_CANNOT_BE_NULL);
        }

        String normalized = email.trim().toLowerCase();

        if (!EMAIL_PATTERN.matcher(normalized).matches()) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_EMAIL_FORMAT);
        }

        this.value = normalized;
    }
}