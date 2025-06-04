package com.example.project1.controller;

import com.example.project1.domain.QuizHistory;
import com.example.project1.service.QuizHistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomeController {

    private final QuizHistoryService quizHistoryService;

    public HomeController(QuizHistoryService quizHistoryService) {
        this.quizHistoryService = quizHistoryService;
    }

    @GetMapping("/home")
    public String getHome(HttpServletRequest request, Model model){
        Integer userId = (Integer) request.getSession().getAttribute("userId");

        if (userId != null) {
            List<QuizHistory> quizHistoryList = quizHistoryService.getQuizHistory(userId);
            model.addAttribute("quiz_history", quizHistoryList);
        }
        return "home";
    }

}
