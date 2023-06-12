package fr.isep.schoolLink.repository;

import fr.isep.schoolLink.entity.SubjectOfInterestEntity;
import fr.isep.schoolLink.entity.UserEntity;
import fr.isep.schoolLink.entity.UserInterestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserInterestRepository extends JpaRepository<UserInterestEntity,Long> {
    //List<UserInterestEntity> findFromUser(UserEntity user);
    Optional<UserInterestEntity> findByUserAndSubjectOfInterest(UserEntity user, SubjectOfInterestEntity subjectOfInterest);
    void deleteByUser(UserEntity user);
}
