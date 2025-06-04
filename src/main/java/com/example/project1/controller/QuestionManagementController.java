package com.example.project1.controller;

import com.example.project1.domain.Question;
import com.example.project1.service.QuestionManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class QuestionManagementController {

    @Autowired
    private QuestionManagementService questionService;

    @GetMapping("/admin/question-management")
    public String showQuestionManagementPage(Model model) {
        List<Question> questions = questionService.getAllQuestions();
        model.addAttribute("questions", questions);
        return "question-management";
    }
}