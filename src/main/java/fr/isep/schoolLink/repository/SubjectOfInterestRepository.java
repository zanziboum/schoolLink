package fr.isep.schoolLink.repository;

import fr.isep.schoolLink.entity.SchoolFormationEntity;
import fr.isep.schoolLink.entity.SubjectOfInterestEntity;
import fr.isep.schoolLink.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectOfInterestRepository extends JpaRepository<SubjectOfInterestEntity,Long> {
    SubjectOfInterestEntity findByName(String name);



}
