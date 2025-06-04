package com.example.project1.controller;

import com.example.project1.domain.Contact;
import com.example.project1.service.AdminContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminContactController {
    @Autowired
    private AdminContactService adminContactService;

    @GetMapping("/contact-us-management")
    public String showContactManagementPage(Model model) {
        List<Contact> contacts = adminContactService.getAllContacts();
        model.addAttribute("contactData", contacts);
        return "contact-us-management";
    }
}
