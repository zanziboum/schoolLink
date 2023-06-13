package fr.isep.schoolLink.controller;

import fr.isep.schoolLink.entity.FollowEntity;
import fr.isep.schoolLink.entity.SchoolEntity;
import fr.isep.schoolLink.entity.UserEntity;
import fr.isep.schoolLink.repository.FollowRepository;
import fr.isep.schoolLink.repository.SchoolRepository;
import fr.isep.schoolLink.repository.UserRepository;
import fr.isep.schoolLink.security.UserPrincipal;
import fr.isep.schoolLink.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/follow")
public class FollowController {
    final SchoolRepository schoolRepository;
    final UserRepository userRepository;
    final FollowRepository followRepository;
    final FollowService followService;

    @PostMapping("add")
    public void addFollow(@RequestParam String schoolName,
                          @AuthenticationPrincipal UserPrincipal principal) {

        Optional<UserEntity> userOptional = userRepository.findById(principal.getUserId());
        Optional<SchoolEntity> schoolOptional = schoolRepository.findByName(schoolName);

        if (userOptional.isEmpty() || schoolOptional.isEmpty()) return;

        UserEntity user = userOptional.get();
        SchoolEntity school = schoolOptional.get();

        followService.addFollow(user, school);
    }

    @PostMapping("delete")
    public void deleteFollow(@RequestParam String schoolName,
                             @AuthenticationPrincipal UserPrincipal principal){
        Optional<UserEntity> userOptional = userRepository.findById(principal.getUserId());
        Optional<SchoolEntity> schoolOptional = schoolRepository.findByName(schoolName);
        if (userOptional.isEmpty() || schoolOptional.isEmpty()) return;
        followService.removeFollow(userOptional.get(),schoolOptional.get());
    }

    @GetMapping("isFollowed")
    public boolean isUserFollowing(@RequestParam String schoolName,
                                   @AuthenticationPrincipal UserPrincipal principal){

        Optional<UserEntity> userOptional = userRepository.findById(principal.getUserId());
        Optional<SchoolEntity> schoolOptional = schoolRepository.findByName(schoolName);

        if (userOptional.isEmpty() || schoolOptional.isEmpty()) return false;
        return followService.isUserFollowedToSchool(
                userOptional.get(),
                schoolOptional.get());
    }
}
