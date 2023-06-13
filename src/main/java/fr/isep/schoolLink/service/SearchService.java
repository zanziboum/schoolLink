package fr.isep.schoolLink.service;

import fr.isep.schoolLink.entity.*;
import fr.isep.schoolLink.repository.*;
import fr.isep.schoolLink.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SearchService {

    final SchoolFormationRepository schoolFormationRepository;
    final SchoolRepository schoolRepository;
    final SubjectOfInterestRepository subjectOfInterestRepository;
    final UserRepository userRepository;
    final UserInterestRepository userInterestRepository;

    public List<SchoolEntity> getSchoolNameWithUser(UserPrincipal principal){

        Optional<UserEntity> userOptional = userRepository.findById(principal.getUserId());
        if(userOptional.isEmpty()) return null;
        List<SchoolEntity> school = new ArrayList<>();

        userOptional
            .get()
            .getInterests()
            .stream()
            .map(UserInterestEntity::getSubjectOfInterest)
            .toList()
            .forEach(interest ->{
            schoolFormationRepository.findBySubjectOfInterest(interest)
                .forEach(formation->{
                    SchoolEntity newSchool = formation.getSchool();
                    if (! school.contains(newSchool)) school.add(newSchool);
            });
        });

        return school ;
    }

}
