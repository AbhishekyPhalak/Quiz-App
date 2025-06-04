package com.example.project1.controller;

import com.example.project1.service.AdminUsersViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ManagePrivilegesController {

    @Autowired
    private AdminUsersViewService adminUsersViewService;

    @PostMapping("/admin/user/activate")
    public String activateUser(@RequestParam int userId) {
        adminUsersViewService.setUserActiveStatus(userId, true);
        return "redirect:/admin/user-management";
    }

    @PostMapping("/admin/user/suspend")
    public String suspendUser(@RequestParam int userId) {
        adminUsersViewService.setUserActiveStatus(userId, false);
        return "redirect:/admin/user-management";
    }

}