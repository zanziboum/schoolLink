package fr.isep.schoolLink.controller;

import fr.isep.schoolLink.entity.UserEntity;
import fr.isep.schoolLink.repository.UserRepository;
import fr.isep.schoolLink.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
public class UserController {

    final UserRepository userRepository;

    @GetMapping("profile")
    public UserEntity getProfile(@AuthenticationPrincipal UserPrincipal principal){
        Optional<UserEntity> userOptional = userRepository.findById(principal.getUserId());
        return userOptional.get();
    }

    @PutMapping("profile")
    public UserEntity updateProfile(@AuthenticationPrincipal UserPrincipal principal, @RequestBody UserEntity updatedUser) {
        Optional<UserEntity> userOptional = userRepository.findById(principal.getUserId());
        System.out.println(userOptional);
        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            // Mettre à jour les champs nécessaires
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setAddress(updatedUser.getAddress());
            return userRepository.save(user);
        }
        return null;
    }
}
