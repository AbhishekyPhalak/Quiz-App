package com.example.project1.controller;

import com.example.project1.domain.User;
import com.example.project1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String email, @RequestParam String password, @RequestParam String firstName, @RequestParam String lastName, RedirectAttributes redirectAttributes) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstname(firstName);
        user.setLastname(lastName);

        boolean isRegistered = userService.RegisterUser(user);
        if(isRegistered){
            return "redirect:/login";
        }
        else{
            redirectAttributes.addFlashAttribute("error", "Email already exists.");
            return "redirect:/register";
        }
    }
}
