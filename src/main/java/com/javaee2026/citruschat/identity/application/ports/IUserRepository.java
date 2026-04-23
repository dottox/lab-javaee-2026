package com.javaee2026.citruschat.identity.application.ports;

import com.javaee2026.citruschat.identity.domain.model.User;
import com.javaee2026.citruschat.identity.domain.valueobjects.PhoneNumber;
import com.javaee2026.citruschat.identity.domain.valueobjects.UserEmail;
import com.javaee2026.citruschat.identity.domain.valueobjects.Username;
import com.javaee2026.citruschat.shared.domain.valueobjects.UserId;

import java.util.Optional;

public interface IUserRepository {
    User save(User user);

    Optional<User> findById(UserId id);
    Optional<User> findByEmail(UserEmail email);
    Optional<User> findByUsername(Username username);
    Optional<User> findByPhoneNumber(PhoneNumber phoneNumber);

    boolean existsByEmail(UserEmail email);
    boolean existsByUsername(Username username);
    boolean existsByPhoneNumber(PhoneNumber phoneNumber);
}