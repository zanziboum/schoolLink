package fr.isep.schoolLink.controller;


import fr.isep.schoolLink.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/school")
public class SchoolController {

    final private SchoolRepository schoolRepository;

    @PostMapping ("/add")
    public boolean addSchool(){
        return true;
    }
}
