package fr.isep.schoolLink.controller;

import fr.isep.schoolLink.entity.SchoolEntity;
import fr.isep.schoolLink.entity.UserEntity;
import fr.isep.schoolLink.repository.SchoolRepository;
import fr.isep.schoolLink.repository.UserRepository;
import fr.isep.schoolLink.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class FollowController {
    final SchoolRepository schoolRepository;
    final UserRepository userRepository;
    @PostMapping("domain")
    public void addFollow(SchoolEntity school, @AuthenticationPrincipal UserPrincipal principal){
        Optional<UserEntity> userOptional = userRepository.findById(principal.getUserId());
        if(userOptional.isPresent()){
            UserEntity user = userOptional.get();
            user.getFollowedSchools().add(school);
            userRepository.save(user);
        }
    }

    @PostMapping("domain")
    public void deleteFollow(SchoolEntity school, @AuthenticationPrincipal UserPrincipal principal){
        Optional<UserEntity> userOptional = userRepository.findById(principal.getUserId());
        if(userOptional.isPresent()){
            UserEntity user = userOptional.get();
            if(user.getFollowedSchools().contains(school)){
                user.getFollowedSchools().remove(school);
                userRepository.save(user);
            }
        }
    }
}
