package com.javaee2026.citruschat.identity.application.usecases;

import com.javaee2026.citruschat.identity.application.commands.LoginCommand;
import com.javaee2026.citruschat.identity.application.exceptions.InvalidCredentialsException;
import com.javaee2026.citruschat.identity.application.ports.IUserRepository;
import com.javaee2026.citruschat.identity.application.results.LoginResult;
import com.javaee2026.citruschat.identity.domain.model.User;
import com.javaee2026.citruschat.identity.domain.valueobjects.PhoneNumber;
import com.javaee2026.citruschat.identity.domain.valueobjects.UserEmail;
import com.javaee2026.citruschat.identity.domain.valueobjects.Username;
import com.javaee2026.citruschat.identity.infrastructure.security.jwt.JwtService;
import com.javaee2026.citruschat.shared.domain.valueobjects.UserId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LoginUserUseCaseTest {

	private IUserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	private JwtService jwtService;
	private LoginUserUseCase loginUserUseCase;

	@BeforeEach
	void setUp() {
		userRepository = mock(IUserRepository.class);
		passwordEncoder = mock(PasswordEncoder.class);
		jwtService = mock(JwtService.class);

		loginUserUseCase = new LoginUserUseCase(userRepository, passwordEncoder, jwtService);
	}

	@Test
	void shouldLoginSuccessfullyWhenCredentialsAreValid() {
		LoginCommand command = new LoginCommand("test@gmail.com", "123456");

		User user = createUser();

		when(userRepository.findByEmail(new UserEmail("test@gmail.com"))).thenReturn(Optional.of(user));

		when(passwordEncoder.matches("123456", user.getPasswordHash())).thenReturn(true);

		when(jwtService.generateToken(user.getId().value().toString(), user.getEmail().getValue(),
				user.getUsername().getValue())).thenReturn("jwt-token");

		LoginResult result = loginUserUseCase.execute(command);

		assertNotNull(result);
		assertEquals(user, result.user());
		assertEquals("jwt-token", result.accessToken());
		assertEquals("Bearer", result.tokenType());
		assertEquals(86400L, result.expiresIn());

		verify(userRepository).findByEmail(new UserEmail("test@gmail.com"));
		verify(passwordEncoder).matches("123456", user.getPasswordHash());
		verify(jwtService).generateToken(user.getId().value().toString(), user.getEmail().getValue(),
				user.getUsername().getValue());
	}

	@Test
	void shouldThrowInvalidCredentialsWhenUserDoesNotExist() {
		LoginCommand command = new LoginCommand("missing@gmail.com", "123456");

		when(userRepository.findByEmail(new UserEmail("missing@gmail.com"))).thenReturn(Optional.empty());

		assertThrows(InvalidCredentialsException.class, () -> loginUserUseCase.execute(command));

		verify(userRepository).findByEmail(new UserEmail("missing@gmail.com"));
		verifyNoInteractions(passwordEncoder);
		verifyNoInteractions(jwtService);
	}

	@Test
	void shouldThrowInvalidCredentialsWhenPasswordIsInvalid() {
		LoginCommand command = new LoginCommand("test@gmail.com", "wrong-password");

		User user = createUser();

		when(userRepository.findByEmail(new UserEmail("test@gmail.com"))).thenReturn(Optional.of(user));

		when(passwordEncoder.matches("wrong-password", user.getPasswordHash())).thenReturn(false);

		assertThrows(InvalidCredentialsException.class, () -> loginUserUseCase.execute(command));

		verify(userRepository).findByEmail(new UserEmail("test@gmail.com"));
		verify(passwordEncoder).matches("wrong-password", user.getPasswordHash());
		verifyNoInteractions(jwtService);
	}

	private User createUser() {
		return new User(new UserId(UUID.fromString("91ae5825-9096-4c74-9447-1bf03004c36b")),
				new UserEmail("test@gmail.com"), new Username("test_test"), new PhoneNumber("099123456"),
				"$2a$10$hashedPassword", Instant.now(), Instant.now(), Instant.now(), null);
	}
}
