package com.example.project1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminViewContactController {
    @PostMapping("/admin/view-contact-info")
    public String viewContactInfo(
            @RequestParam String subject,
            @RequestParam String email,
            @RequestParam String message,
            @RequestParam String time,
            Model model
    ) {
        model.addAttribute("subject", subject);
        model.addAttribute("email", email);
        model.addAttribute("message", message);
        model.addAttribute("time", time);
        return "view-contact-info";
    }
}
