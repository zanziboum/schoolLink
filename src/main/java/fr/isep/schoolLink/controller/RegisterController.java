package fr.isep.schoolLink.controller;

import fr.isep.schoolLink.entity.UserEntity;
import fr.isep.schoolLink.model.LoginRequest;
import fr.isep.schoolLink.model.LoginResponse;
import fr.isep.schoolLink.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegisterController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("api/auth/register")
    public String register(@RequestBody @Validated LoginRequest credentials){
        userService.AddUser(
                userService.createUser(credentials.getEmail(), passwordEncoder.encode(credentials.getPassword()))
        );

        return "user added";
    }
}
