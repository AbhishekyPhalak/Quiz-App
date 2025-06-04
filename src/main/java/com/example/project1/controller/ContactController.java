package com.example.project1.controller;

import com.example.project1.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/contact")
    public String showContactForm() {
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContactForm(@RequestParam String subject, @RequestParam String email,
                                    @RequestParam String message) {

        contactService.addContact(subject, message, email);
        return "contact";

    }
}
