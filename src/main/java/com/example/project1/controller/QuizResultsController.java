package com.example.project1.controller;

import com.example.project1.domain.QuizResultsData;
import com.example.project1.service.QuizResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class QuizResultsController {

    private final QuizResultsService quizResultsService;

    @Autowired
    public QuizResultsController(QuizResultsService quizResultsService) {
        this.quizResultsService = quizResultsService;
    }

    @PostMapping("/quiz-results")
    public String showQuizResults(@RequestParam("quizId") int quizId, HttpServletRequest request, Model model) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        QuizResultsData quizResultsData = quizResultsService.getQuizResults(quizId, userId);
        model.addAttribute("quizResultsData", quizResultsData);
        return "quiz-result";
    }

    @GetMapping("/quiz-results")
    public String getQuizResults(@RequestParam("quizId") int quizId, HttpServletRequest request, Model model) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        QuizResultsData quizResultsData = quizResultsService.getQuizResults(quizId, userId);
        model.addAttribute("quizResultsData", quizResultsData);
        return "quiz-result";
    }

    @PostMapping(value = "/quiz-results", params = {"quizId", "userId"})
    public String showQuizResultsWithUser(@RequestParam("quizId") int quizId,
                                          @RequestParam("userId") int userId,
                                          Model model) {
        QuizResultsData quizResultsData = quizResultsService.getQuizResults(quizId, userId);
        model.addAttribute("quizResultsData", quizResultsData);
        return "quiz-result";
    }

}