package fr.isep.schoolLink.controller;

import fr.isep.schoolLink.model.LoginRequest;
import fr.isep.schoolLink.model.LoginResponse;
import fr.isep.schoolLink.model.SignUpRequest;
import fr.isep.schoolLink.security.UserPrincipal;
import fr.isep.schoolLink.service.AuthService;
import fr.isep.schoolLink.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("login")
    public LoginResponse login(@RequestBody @Validated LoginRequest request){
        return authService.attemptLogin(request.getEmail(),request.getPassword());
    }

    @PostMapping("register")
    public String register(@RequestBody @Validated SignUpRequest credentials){
        System.out.println("password:");
        System.out.println(credentials.getPassword());
        userService.AddUser(
                userService.createUser(credentials.getFirstName(),
                        credentials.getLastName(),
                        credentials.getEmail(),
                        passwordEncoder.encode(credentials.getPassword()),
                        credentials.getAddress()));
        return "user added";
    }

    @GetMapping("checkToken")
    public boolean isTokenValid(@AuthenticationPrincipal UserPrincipal principal){
        return principal != null;
    }

    @GetMapping("/checkEmail")
    public ResponseEntity<String> checkEmail(@RequestParam String email) {
        if (userService.existsByEmail(email)) {
            // L'e-mail existe déjà dans la base de données
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Une adresse e-mail similaire existe déjà.");
        } else {
            // L'e-mail n'existe pas dans la base de données
            return ResponseEntity.ok("Adresse e-mail disponible.");
        }
    }


}


