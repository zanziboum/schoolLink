package fr.isep.schoolLink.controller;


import fr.isep.schoolLink.model.LoginRequest;
import fr.isep.schoolLink.model.LoginResponse;
import fr.isep.schoolLink.model.SignUpRequestSchoolProfile;
import fr.isep.schoolLink.service.AuthService;
import fr.isep.schoolLink.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/school")
public class SchoolController {

    private final PasswordEncoder passwordEncoder;
    private final SchoolService schoolService;
    private final AuthService authService;

    @PostMapping ("/register")
    public String addSchool(@RequestBody @Validated SignUpRequestSchoolProfile credentials){
        System.out.println("password:");
        System.out.println(credentials.getPassword());
        schoolService.AddSchool(
                schoolService.createSchool(credentials.getName(),
                        credentials.getEmail(),
                        passwordEncoder.encode(credentials.getPassword()),
                        credentials.getAddress()));
        return "school added";
    }
    @PostMapping("login")
    public LoginResponse login(@RequestBody @Validated LoginRequest request){
        return authService.attemptLogin(request.getEmail(),request.getPassword());
    }
    @GetMapping("/checkEmail")
    public ResponseEntity<String> checkEmail(@RequestParam String email) {
        if (schoolService.existsByEmail(email)) {
            // L'e-mail existe déjà dans la base de données
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Une adresse e-mail similaire existe déjà.");
        } else {
            // L'e-mail n'existe pas dans la base de données
            return ResponseEntity.ok("Adresse e-mail disponible.");
        }
    }

    @GetMapping("test")
    public void testOui(){
        schoolService.testadd();
    }


}
