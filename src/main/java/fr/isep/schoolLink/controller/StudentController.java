package fr.isep.schoolLink.controller;

import fr.isep.schoolLink.data.StudentDAO;
import fr.isep.schoolLink.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/student")
    public String addStudent(@RequestParam("name") String name,
                             @RequestParam("lname") String lname,
                             @RequestParam("email") String email){
        Student student = new Student();
        student.setName(name);
        student.setLname(lname);
        student.setEmail(email);
        studentDAO.save(student);
        return "redirect:/student";
    }
}
