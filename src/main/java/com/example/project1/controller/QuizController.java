package com.example.project1.controller;

import com.example.project1.domain.QuestionWithChoice;
import com.example.project1.service.QuizService;
import com.example.project1.service.SaveQuizQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class QuizController {

    @Autowired
    QuizService quizService;

    @Autowired
    SaveQuizQuestionService saveQuizQuestionService;

    @GetMapping("/quiz")
    public String showQuiz(@RequestParam String category, Model model){
        List<QuestionWithChoice> quizData =  quizService.getQuizData(category);
        model.addAttribute("quizData", quizData);
        model.addAttribute("quizStartTime", System.currentTimeMillis());
        return "quiz";
    }

    @PostMapping("/quiz")
    public String submitQuiz(@RequestParam Integer categoryId, @RequestParam("timeStart") Long timeStart, HttpServletRequest request, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");

        Long timeEnd = System.currentTimeMillis();

        Integer quizId = quizService.saveQuiz(userId, categoryId, timeStart, timeEnd);

        Map<String, String[]> paramMap = request.getParameterMap();
        saveQuizQuestionService.saveQuizQuestions(quizId, paramMap);

        return "redirect:/quiz-results?quizId=" + quizId;
    }
}
