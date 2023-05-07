package fr.isep.schoolLink.repository;

import fr.isep.schoolLink.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface StudentRepository extends JpaRepository<Student,Long> {

}
