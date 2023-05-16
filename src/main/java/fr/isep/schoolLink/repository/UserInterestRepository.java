package fr.isep.schoolLink.repository;

import fr.isep.schoolLink.entity.SubjectOfInterestEntity;
import fr.isep.schoolLink.entity.UserEntity;
import fr.isep.schoolLink.entity.UserInterestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserInterestRepository extends JpaRepository<UserInterestEntity,Long> {
    //List<UserInterestEntity> findFromUser(UserEntity user);
}
