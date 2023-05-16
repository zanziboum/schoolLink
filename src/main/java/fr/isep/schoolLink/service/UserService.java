package fr.isep.schoolLink.service;

import fr.isep.schoolLink.entity.UserEntity;
import fr.isep.schoolLink.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    //

    public Optional<UserEntity> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public void AddUser(UserEntity user){
        userRepository.save(user);
    }

    public UserEntity createUser(String email, String password){
        UserEntity user = new UserEntity();
        user.setEmail(email);
        user.setPassword(password);
        user.setRole("USER");
        return user;

    }

}
