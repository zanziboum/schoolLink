package fr.isep.schoolLink;

import fr.isep.schoolLink.controller.StudentController;
import fr.isep.schoolLink.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class SampleController {
    Map <String, Object> map = new HashMap<>();
    @GetMapping("/user/information")
    public Map<String, Object> currentUser (OAuth2AuthenticationToken oAuth2AuthenticationToken){
        map = oAuth2AuthenticationToken.getPrincipal().getAttributes();
        return map;
    }

    public String getFirstName(Map map) {
        String result = null;
        for (int i = 0;i< map.size(); i++) {
            if (map.containsKey("given_name")) {
               result =  map.values().toString();
            }
        }
        return result;
    }
    public String getLastName(Map map) {
        String result = null;
        for (int i = 0;i< map.size(); i++) {
            if (map.containsKey("family_name")) {
                result =  map.values().toString();
            }
        }
        return result;
    }
    public String getEmail(Map map) {
        String result = null;
        for (int i = 0;i< map.size(); i++) {
            if (map.containsKey("email")) {
                result =  map.values().toString();
            }
        }
        return result;
    }
    public String getGoogleKey(Map map) {
        String result = null;
        for (int i = 0;i< map.size(); i++) {
            if (map.containsKey("at_h")) {
                result =  map.values().toString();
            }
        }
        return result;
    }
    @Autowired
    public StudentController studentController;
    @PostMapping("/student/google/login")
    public  String addStudentFromGoogle(String name, String lastName, String email, String googleKey){
        Student student = new Student();
        student.setGoogleKey(googleKey);
        student.setEmail(getEmail(map));
        student.setName(getEmail(map));
        student.setLname(getEmail(map));
        return "redirect:/student";
    }
}
