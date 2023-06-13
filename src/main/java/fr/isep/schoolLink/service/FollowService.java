package fr.isep.schoolLink.service;

import fr.isep.schoolLink.entity.FollowEntity;
import fr.isep.schoolLink.entity.SchoolEntity;
import fr.isep.schoolLink.entity.UserEntity;
import fr.isep.schoolLink.repository.FollowRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FollowService {

    final FollowRepository followRepository;

    public void addFollow(UserEntity user, SchoolEntity school) {

        if (followRepository.findByUserAndSchool(user,school).isPresent()) return;

        FollowEntity follow = new FollowEntity();
        follow.setUser(user);
        follow.setSchool(school);

        followRepository.save(follow);
    }


    public void removeFollow(UserEntity user, SchoolEntity school){
        Optional<FollowEntity> followOptional = followRepository.findByUserAndSchool(user,school);
        if (followOptional.isEmpty()) return;


        followRepository.deleteById(followOptional.get().getId());
    }

    public boolean isUserFollowedToSchool(UserEntity user, SchoolEntity school){
        return followRepository.findByUserAndSchool(user,school).isPresent();
    }
}
