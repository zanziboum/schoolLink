package fr.isep.schoolLink.repository;

import fr.isep.schoolLink.entity.SchoolEntity;
import fr.isep.schoolLink.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SchoolRepository extends JpaRepository<SchoolEntity,Long> {
    Optional<SchoolEntity> findByEmail(String email);
    Optional<SchoolEntity> findByName(String name);


}
