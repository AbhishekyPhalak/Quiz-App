package com.example.project1.controller;

import com.example.project1.service.QuestionPrivilegesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuestionPrivilegesController {

    @Autowired
    private QuestionPrivilegesService questionPrivilegesService;

    @PostMapping("/admin/question/activate")
    public String activateQuestion(@RequestParam("questionId") int questionId) {
        questionPrivilegesService.setQuestionActiveStatus(questionId, true);
        return "redirect:/admin/question-management";
    }

    @PostMapping("/admin/question/suspend")
    public String suspendQuestion(@RequestParam("questionId") int questionId) {
        questionPrivilegesService.setQuestionActiveStatus(questionId, false);
        return "redirect:/admin/question-management";
    }
}