package fr.isep.schoolLink.data;

import fr.isep.schoolLink.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface StudentDAO extends JpaRepository<Student,Long> {

}
