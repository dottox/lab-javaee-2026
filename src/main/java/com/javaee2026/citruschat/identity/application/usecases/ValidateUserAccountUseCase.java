package com.javaee2026.citruschat.identity.application.usecases;

import com.javaee2026.citruschat.identity.application.commands.ValidateUserAccountCommand;
import com.javaee2026.citruschat.identity.application.ports.IPasswordHasher;
import com.javaee2026.citruschat.identity.application.ports.IUserRepository;
import com.javaee2026.citruschat.identity.domain.model.User;
import com.javaee2026.citruschat.identity.domain.valueobjects.Username;
import com.javaee2026.citruschat.shared.domain.constants.ErrorMessages;

public class ValidateUserAccountUseCase {

	private final IUserRepository userRepository;
	private final IPasswordHasher passwordHasher;

	public ValidateUserAccountUseCase(final IUserRepository userRepository, final IPasswordHasher passwordHasher) {
		this.userRepository = userRepository;
		this.passwordHasher = passwordHasher;
	}

	public void execute(final ValidateUserAccountCommand command) {
		final Username username = new Username(command.username());

		final User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new IllegalArgumentException(ErrorMessages.USER_NOT_FOUND));

		if (!passwordHasher.matches(command.temporaryPassword(), user.getPasswordHash())) {
			throw new IllegalArgumentException(ErrorMessages.INVALID_TEMPORARY_PASSWORD);
		}

		final String newPasswordHash = passwordHasher.hash(command.newPassword());

		user.validateAccount(newPasswordHash);

		userRepository.save(user);
	}
}
