package com.example.project1.controller;

import com.example.project1.domain.AdminQuizResultDTO;
import com.example.project1.service.AdminQuizResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminQuizResultsController {

    @Autowired
    private AdminQuizResultsService quizResultsService;

    @GetMapping("/admin/quiz-results")
    public String getAllQuizResults(@RequestParam(required = false) String category,
                                    @RequestParam(required = false) String userId,
                                    Model model) {
        List<AdminQuizResultDTO> results;

        if ((category == null || category.isEmpty()) && (userId == null || userId.isEmpty())) {
            results = quizResultsService.fetchAllQuizResults();
        } else {
            results = quizResultsService.fetchFilteredResults(category, userId);
        }

        model.addAttribute("quizResults", results);
        return "quiz-results";
    }

}