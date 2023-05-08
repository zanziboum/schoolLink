package fr.isep.schoolLink.controller;

import fr.isep.schoolLink.model.LoginRequest;
import fr.isep.schoolLink.model.LoginResponse;
import fr.isep.schoolLink.service.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {

    //TODO: front end connection

    private final AuthService authService;

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "loginPage";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("loginRequest") @Validated
                        LoginRequest loginRequest,
                        BindingResult result,
                        Model model,
                        HttpServletResponse response) {

        if (result.hasErrors()) {

            return "loginPage";
        }

        LoginResponse loginResponse = authService.attemptLogin(loginRequest.getEmail(), loginRequest.getPassword());

        String token = loginResponse.getAccesToken();

        if (token != null) {
            Cookie cookie = new Cookie("jwtToken", token);
            response.addCookie(cookie);
            return "redirect:/home";
        } else {
            model.addAttribute("errorMessage", "Invalid email or password");
            return "loginPage";
        }
    }
}
