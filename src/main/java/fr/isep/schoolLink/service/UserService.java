package fr.isep.schoolLink.service;

import fr.isep.schoolLink.entity.UserEntity;
import fr.isep.schoolLink.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<UserEntity> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

}
