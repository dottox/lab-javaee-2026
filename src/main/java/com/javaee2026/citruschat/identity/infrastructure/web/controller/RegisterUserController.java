package com.javaee2026.citruschat.identity.infrastructure.web.controller;

import com.javaee2026.citruschat.identity.application.commands.RegisterUserCommand;
import com.javaee2026.citruschat.identity.application.results.RegisterUserResult;
import com.javaee2026.citruschat.identity.application.usecases.RegisterUserUseCase;
import com.javaee2026.citruschat.identity.infrastructure.web.dto.request.RegisterUserRequest;
import com.javaee2026.citruschat.identity.infrastructure.web.dto.response.RegisterUserResponse;
import com.javaee2026.citruschat.shared.infrastructure.constants.ApiRoutes;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiRoutes.API_USERS)
public class RegisterUserController {


    private final RegisterUserUseCase registerUserUseCase;

    public RegisterUserController(RegisterUserUseCase registerUserUseCase) {
        this.registerUserUseCase = registerUserUseCase;
    }

    @PostMapping
    public RegisterUserResponse register(@RequestBody RegisterUserRequest request) {
        RegisterUserCommand command = new RegisterUserCommand(
                request.email(),
                request.username(),
                request.phoneNumber()
        );

        RegisterUserResult result = registerUserUseCase.execute(command);

        return new RegisterUserResponse(
                result.user().getId().value().toString(),
                result.user().getEmail().getValue(),
                result.user().getUsername().getValue(),
                result.user().getPhoneNumber().getValue(),
                result.temporaryPassword()
        );
    }
}