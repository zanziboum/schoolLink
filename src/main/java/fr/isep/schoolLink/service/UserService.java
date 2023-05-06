package fr.isep.schoolLink.service;

import fr.isep.schoolLink.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    //private final UserRepository
    private static final String EXISTING_EMAIL = "test@test.com";
    public Optional<UserEntity> findByEmail(String email){
        //TODO: Move this to database
        if(! EXISTING_EMAIL.equalsIgnoreCase(email)) return Optional.empty();

        var user = new UserEntity();
        user.setId(1L);
        user.setEmail(EXISTING_EMAIL);
        user.setPassword("$2a$12$PHYBFaUc3tNJmMX5XaOROeG0vpGDtpumicGVFpOtitw/6XXP8cDMm");
        user.setRole("ADMIN");
        user.setExtraInfo("Nice user");
        return Optional.of(user);
    }
}
