package fr.isep.schoolLink.repository;

import fr.isep.schoolLink.entity.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<SchoolEntity,Long> {
    SchoolEntity findByName(String name);

}
