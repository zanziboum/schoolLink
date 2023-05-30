package fr.isep.schoolLink.controller;

import fr.isep.schoolLink.entity.SubjectOfInterestEntity;
import fr.isep.schoolLink.entity.UserEntity;
import fr.isep.schoolLink.entity.UserInterestEntity;
import fr.isep.schoolLink.model.UserUpdateRequest;
import fr.isep.schoolLink.repository.SubjectOfInterestRepository;
import fr.isep.schoolLink.repository.UserRepository;
import fr.isep.schoolLink.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
public class UserController {

    final UserRepository userRepository;
    final SubjectOfInterestRepository subjectOfInterestRepository;

    @GetMapping("profile")
    public UserEntity getProfile(@AuthenticationPrincipal UserPrincipal principal){
        Optional<UserEntity> userOptional = userRepository.findById(principal.getUserId());
        return userOptional.get();
    }

    @PutMapping("update")
    @Transactional
    public UserEntity updateProfile(@AuthenticationPrincipal UserPrincipal principal, @RequestBody UserUpdateRequest request) {
        Optional<UserEntity> userOptional = userRepository.findById(principal.getUserId());

        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            user.setFirstName(request.getFirstName());
            user.setLastName(request.getLastName());
            user.setAddress(request.getAddress());

            List<UserInterestEntity> interests = new ArrayList<>();
            for (String subjectName : request.getInterests()) {
                SubjectOfInterestEntity subject = subjectOfInterestRepository.findByName(subjectName);
                if (subject != null) {
                    UserInterestEntity userInterest = new UserInterestEntity();
                    userInterest.setUser(user);
                    userInterest.setSubjectOfInterest(subject);
                    interests.add(userInterest);
                    System.out.println(userInterest);
                }
            }
            user.setInterests(interests);

            return userRepository.save(user);
        }
        return null;
    }
}
