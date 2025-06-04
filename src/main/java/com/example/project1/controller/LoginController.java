package com.example.project1.controller;

import com.example.project1.domain.User;
import com.example.project1.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String showLogin(HttpSession session){
        if (session != null && session.getAttribute("userId") != null) {
            return "redirect:/home";  // Already logged in
        }
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String email, @RequestParam String password, HttpServletRequest request, RedirectAttributes redirectAttributes, HttpSession session){

        User user = loginService.validateUser(email, password);
        if(user!=null){
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("isAdmin", user.isAdmin());
            if (user.isAdmin()) {
               return "redirect:/admin/home";
            } else {
                return "redirect:/home";
            }
        }
        else{
            redirectAttributes.addFlashAttribute( "error", "Invalid username or password.");
            return "login";
        }
    }

}
