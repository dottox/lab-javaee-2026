package com.javaee2026.citruschat.identity.infrastructure.configuration;

import com.javaee2026.citruschat.identity.application.ports.IDefaultPasswordGenerator;
import com.javaee2026.citruschat.identity.application.ports.IPasswordHasher;
import com.javaee2026.citruschat.identity.application.ports.IUserRepository;
import com.javaee2026.citruschat.identity.application.usecases.RegisterUserUseCase;
import com.javaee2026.citruschat.identity.domain.factory.UserFactory;
import com.javaee2026.citruschat.identity.infrastructure.persistence.jpa.mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IdentityBeansConfiguration {

    @Bean
    public UserFactory userFactory() {
        return new UserFactory();
    }

    @Bean
    public UserMapper userMapper(UserFactory userFactory) {
        return new UserMapper(userFactory);
    }

    @Bean
    public RegisterUserUseCase registerUserUseCase(
            IUserRepository userRepository,
            IDefaultPasswordGenerator defaultPasswordGenerator,
            IPasswordHasher passwordHasher,
            UserFactory userFactory
    ) {
        return new RegisterUserUseCase(
                userRepository,
                defaultPasswordGenerator,
                passwordHasher,
                userFactory
        );
    }
}