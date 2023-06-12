package fr.isep.schoolLink.service;

import fr.isep.schoolLink.entity.FollowEntity;
import fr.isep.schoolLink.entity.SchoolEntity;
import fr.isep.schoolLink.entity.UserEntity;
import fr.isep.schoolLink.repository.FollowRepository;
import org.springframework.stereotype.Service;

@Service
public class FollowService {
    final FollowRepository followRepository;

    public FollowService(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }

    public void addFollow(UserEntity user, SchoolEntity school) {
        FollowEntity follow = new FollowEntity();
        follow.setUser(user);
        follow.setSchool(school);
        followRepository.save(follow);
    }
}
