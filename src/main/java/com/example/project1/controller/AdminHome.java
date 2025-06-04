package com.example.project1.controller;

import com.example.project1.service.AdminStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

@Controller
public class AdminHome {

    @Autowired
    AdminStatsService adminStatsService;

    @GetMapping("/admin/home")
    public String getAdminHome(Model model) {
        HashMap<String, String> stats =  adminStatsService.getAdminStats();
        model.addAttribute("stats", stats);
        return "admin-home";
    }
}
