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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void addFollow(String schoolName, @AuthenticationPrincipal UserPrincipal principal) {
        Optional<UserEntity> userOptional = userRepository.findById(principal.getUserId());
        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            Optional<SchoolEntity> schoolOptional = Optional.ofNullable(schoolRepository.findByName(schoolName));
            if (schoolOptional.isPresent()) {
                SchoolEntity school = schoolOptional.get();
                followService.addFollow(user, school);
            }
        }
    }

    @PostMapping("delete")
    public void deleteFollow(SchoolEntity school, @AuthenticationPrincipal UserPrincipal principal){
        Optional<UserEntity> userOptional = userRepository.findById(principal.getUserId());
        if(userOptional.isPresent()){
            UserEntity user = userOptional.get();
            FollowEntity follow = new FollowEntity();

            follow.setUser(user);
            follow.setSchool(school);
            if (user.getFollowedSchools().contains(follow)){
                followRepository.delete(follow);
            }


        }
    }
}
