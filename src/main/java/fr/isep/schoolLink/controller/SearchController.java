package fr.isep.schoolLink.controller;

import fr.isep.schoolLink.entity.*;
import fr.isep.schoolLink.repository.*;
import fr.isep.schoolLink.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/search")
public class SearchController {

    final SchoolFormationRepository schoolFormationRepository;
    final SchoolRepository schoolRepository;
    final SubjectOfInterestRepository subjectOfInterestRepository;
    final UserRepository userRepository;
    final UserInterestRepository userInterestRepository;


    @PostMapping("domain")
    public String getSchoolMaths(@RequestBody String domain){
        SubjectOfInterestEntity interest = subjectOfInterestRepository.findByName(domain);
        List<SchoolFormationEntity> formations = schoolFormationRepository.findBySubjectOfInterest(interest);
        Optional<SchoolEntity> school = schoolRepository.findById(formations.get(0).getId());
        return school.get().getName();
    }

    @GetMapping ("school")
    public String getSchoolWithUser(@AuthenticationPrincipal UserPrincipal principal){

        Optional<UserEntity> user = userRepository.findById(principal.getUserId());
        return String.valueOf(user.get().getInterest().size());

    }
}
