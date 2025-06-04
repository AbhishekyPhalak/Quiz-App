package com.example.project1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/question")
public class QuestionEditController {

    @GetMapping("/edit")
    public String showEditForm(
            @RequestParam("questionId") int questionId,
            @RequestParam("description") String description,
            @RequestParam("choice1") String choice1,
            @RequestParam("choice2") String choice2,
            @RequestParam("choice3") String choice3,
            @RequestParam("choiceId1") int choiceId1,
            @RequestParam("choiceId2") int choiceId2,
            @RequestParam("choiceId3") int choiceId3,
            Model model) {

        model.addAttribute("questionId", questionId);
        model.addAttribute("description", description);
        model.addAttribute("choice1", choice1);
        model.addAttribute("choice2", choice2);
        model.addAttribute("choice3", choice3);
        model.addAttribute("choiceId1", choiceId1);
        model.addAttribute("choiceId2", choiceId2);
        model.addAttribute("choiceId3", choiceId3);

        return "edit-question";
    }

    @PostMapping("/edit")
    public String submitEditForm() {
        return "redirect:/admin/question-management";
    }
}
