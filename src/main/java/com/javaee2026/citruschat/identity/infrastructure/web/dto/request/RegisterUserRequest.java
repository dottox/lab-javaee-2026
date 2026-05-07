package com.javaee2026.citruschat.identity.infrastructure.web.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RegisterUserRequest(

		@NotBlank(message = "Email is required") @Email(message = "Invalid email format") String email,

		@NotBlank(message = "Phone number is required") @Pattern(regexp = "^\\+?[0-9]{8,15}$", message = "Invalid phone number format") String phoneNumber,

		@NotBlank(message = "First name is required") @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters") String firstName,

		@NotBlank(message = "Last name is required") @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters") String lastName

) {
}
