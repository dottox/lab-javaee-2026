package com.javaee2026.citruschat.shared.domain.constants;

public final class ErrorMessages {

    private ErrorMessages() {
    }

    public static final String UNEXPECTED_ERROR = "Unexpected error";

    public static final String EMAIL_ALREADY_IN_USE = "Email already in use";
    public static final String USERNAME_ALREADY_IN_USE = "Username already in use";
    public static final String PHONE_NUMBER_ALREADY_IN_USE = "Phone number already in use";

    public static final String USER_ID_CANNOT_BE_NULL = "UserId cannot be null";
    public static final String USER_ALREADY_ACTIVE = "User already active";
    public static final String USER_ALREADY_INACTIVE = "User already inactive";

    public static final String PASSWORD_HASH_CANNOT_BE_NULL = "Password hash cannot be null";
    public static final String CREATED_AT_CANNOT_BE_NULL = "createdAt cannot be null";
    public static final String UPDATED_AT_CANNOT_BE_NULL = "updatedAt cannot be null";

    public static final String EMAIL_CANNOT_BE_NULL = "Email cannot be null";
    public static final String INVALID_EMAIL_FORMAT = "Invalid email format";

    public static final String USERNAME_CANNOT_BE_NULL = "Username cannot be null";
    public static final String USERNAME_CANNOT_BE_EMPTY = "Username cannot be empty";
    public static final String USERNAME_INVALID_CHARACTERS =
            "Username can only contain lowercase letters, numbers and underscore";
    public static final String USERNAME_INVALID_BOUNDARY_UNDERSCORE =
            "Username cannot start or end with underscore";
    public static final String USERNAME_CONSECUTIVE_UNDERSCORES =
            "Username cannot contain consecutive underscores";

    public static final String PHONE_NUMBER_CANNOT_BE_NULL = "Phone number cannot be null";
    public static final String INVALID_PHONE_NUMBER_FORMAT = "Invalid phone number format";

    public static String usernameLengthBetween(int min, int max) {
        return "Username must be between " + min + " and " + max + " characters";
    }
}