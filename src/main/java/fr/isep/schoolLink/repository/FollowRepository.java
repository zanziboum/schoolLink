package fr.isep.schoolLink.repository;

import fr.isep.schoolLink.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FollowRepository extends JpaRepository<FollowEntity,Long> {
    Optional<FollowEntity> findByUserAndSchool(UserEntity user, SchoolEntity school);
    List<FollowEntity> findByUser(UserEntity user);
}
