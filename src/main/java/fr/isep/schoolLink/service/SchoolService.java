package fr.isep.schoolLink.service;

import fr.isep.schoolLink.entity.SchoolEntity;
import fr.isep.schoolLink.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepository;

    public Optional<SchoolEntity> findByEmail(String email){
        return schoolRepository.findByEmail(email);
    }

    public void AddSchool(SchoolEntity school){
        schoolRepository.save(school);
    }

    public SchoolEntity createSchool(String name, String email, String password, String address){
        SchoolEntity school = new SchoolEntity();
        school.setName(name);
        school.setEmail(email);
        school.setPassword(password);
        school.setAddress(address);
        school.setRole("USER");
        return school;
    }
    public boolean existsByEmail(String email) {
        Optional<SchoolEntity> school = schoolRepository.findByEmail(email);
        return !school.isPresent();
    }
}
