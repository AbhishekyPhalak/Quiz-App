package com.example.project1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String Logout(HttpSession session){
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/login";
    }
}
