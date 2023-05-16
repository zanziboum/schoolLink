package fr.isep.schoolLink.repository;

import fr.isep.schoolLink.entity.SchoolFormationEntity;
import fr.isep.schoolLink.entity.SubjectOfInterestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolFormationRepository extends JpaRepository<SchoolFormationEntity,Long> {
    List<SchoolFormationEntity> findBySubjectOfInterest(SubjectOfInterestEntity subjectOfInterest);
}
