package fr.isep.schoolLink.repository;

import fr.isep.schoolLink.entity.SchoolEntity;
import fr.isep.schoolLink.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SchoolRepository extends JpaRepository<SchoolEntity,Long> {
    Optional<SchoolEntity> findByEmail(String email);
    Optional<SchoolEntity> findByName(String name);


}
