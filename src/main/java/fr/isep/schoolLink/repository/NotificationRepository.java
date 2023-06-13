package fr.isep.schoolLink.repository;

import fr.isep.schoolLink.entity.NotificationEntity;
import fr.isep.schoolLink.entity.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<NotificationEntity,Long> {
    List<NotificationEntity> findBySchool(SchoolEntity school);
}
