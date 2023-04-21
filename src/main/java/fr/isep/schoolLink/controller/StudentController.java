package fr.isep.schoolLink.controller;

import fr.isep.schoolLink.data.StudentDAO;
import fr.isep.schoolLink.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentDAO studentDAO;


    @GetMapping("/student")
    public String showPage(Model model){
        List<Student> students = studentDAO.findAll();
        model.addAttribute("students", students);


        return "StudentPage";
    }
}
