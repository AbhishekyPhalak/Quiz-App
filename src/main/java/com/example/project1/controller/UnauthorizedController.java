package com.example.project1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UnauthorizedController {


    @GetMapping("/unauthorized")
    public String showUnauthorizedPage() {
        return "unauthorized";
    }

}
