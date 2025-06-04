package com.example.project1.controller;

import com.example.project1.service.QuestionUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/question")
public class QuestionUpdateController {

    @Autowired
    private QuestionUpdateService questionUpdateService;

    @PostMapping("/update")
    public String updateQuestion(
            @RequestParam("questionId") int questionId,
            @RequestParam("description") String description,
            @RequestParam("choiceId1") int choiceId1,
            @RequestParam("choice1") String choice1,
            @RequestParam("choiceId2") int choiceId2,
            @RequestParam("choice2") String choice2,
            @RequestParam("choiceId3") int choiceId3,
            @RequestParam("choice3") String choice3,
            @RequestParam("correctChoice") int correctChoice
    ) {
        questionUpdateService.updateQuestionAndChoices(
                questionId, description,
                choiceId1, choice1,
                choiceId2, choice2,
                choiceId3, choice3,
                correctChoice
        );

        return "redirect:/admin/question-management";
    }
}
