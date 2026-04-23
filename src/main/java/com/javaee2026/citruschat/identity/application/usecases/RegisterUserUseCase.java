package com.javaee2026.citruschat.identity.application.usecases;

import com.javaee2026.citruschat.identity.application.commands.RegisterUserCommand;
import com.javaee2026.citruschat.identity.application.exceptions.EmailAlreadyInUseException;
import com.javaee2026.citruschat.identity.application.exceptions.PhoneNumberAlreadyInUseException;
import com.javaee2026.citruschat.identity.application.exceptions.UsernameAlreadyInUseException;
import com.javaee2026.citruschat.identity.application.ports.IDefaultPasswordGenerator;
import com.javaee2026.citruschat.identity.application.ports.IPasswordHasher;
import com.javaee2026.citruschat.identity.application.ports.IUserRepository;
import com.javaee2026.citruschat.identity.application.results.RegisterUserResult;
import com.javaee2026.citruschat.identity.domain.factory.UserFactory;
import com.javaee2026.citruschat.identity.domain.model.User;
import com.javaee2026.citruschat.identity.domain.valueobjects.PhoneNumber;
import com.javaee2026.citruschat.identity.domain.valueobjects.UserEmail;
import com.javaee2026.citruschat.identity.domain.valueobjects.Username;

public class RegisterUserUseCase {

    private final IUserRepository userRepository;
    private final IDefaultPasswordGenerator defaultPasswordGenerator;
    private final IPasswordHasher passwordHasher;
    private final UserFactory userFactory;

    public RegisterUserUseCase(
            IUserRepository userRepository,
            IDefaultPasswordGenerator defaultPasswordGenerator,
            IPasswordHasher passwordHasher,
            UserFactory userFactory
    ) {
        this.userRepository = userRepository;
        this.defaultPasswordGenerator = defaultPasswordGenerator;
        this.passwordHasher = passwordHasher;
        this.userFactory = userFactory;
    }

    public RegisterUserResult execute(RegisterUserCommand command) {
        UserEmail email = new UserEmail(command.email());
        Username username = new Username(command.username());
        PhoneNumber phoneNumber = new PhoneNumber(command.phoneNumber());

        ensureEmailIsAvailable(email);
        ensureUsernameIsAvailable(username);
        ensurePhoneNumberIsAvailable(phoneNumber);

        String temporaryPassword = defaultPasswordGenerator.generate();
        String passwordHash = passwordHasher.hash(temporaryPassword);

        User user = userFactory.createNew(
                email,
                username,
                phoneNumber,
                passwordHash
        );

        User savedUser = userRepository.save(user);

        return new RegisterUserResult(savedUser, temporaryPassword);
    }

    private void ensureEmailIsAvailable(UserEmail email) {
        if (userRepository.existsByEmail(email)) {
            throw new EmailAlreadyInUseException();
        }
    }

    private void ensureUsernameIsAvailable(Username username) {
        if (userRepository.existsByUsername(username)) {
            throw new UsernameAlreadyInUseException();
        }
    }

    private void ensurePhoneNumberIsAvailable(PhoneNumber phoneNumber) {
        if (userRepository.existsByPhoneNumber(phoneNumber)) {
            throw new PhoneNumberAlreadyInUseException();
        }
    }
}