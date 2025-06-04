package com.example.project1.controller;

import com.example.project1.domain.User;
import com.example.project1.service.AdminUsersViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminUserController {

    @Autowired
    private AdminUsersViewService adminUsersViewService;

    @GetMapping("/admin/user-management")
    public String showUserManagementPage(Model model) {
        List<User> users = adminUsersViewService.getAllUsers();
        model.addAttribute("users", users);
        return "admin-user-management";
    }
}