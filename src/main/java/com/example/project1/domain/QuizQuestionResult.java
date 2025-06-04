package com.example.project1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizQuestionResult {
    private int questionId;
    private String questionDesc;

    private int userChoiceId;
    private String userChoiceDesc;

    private int correctChoiceId;
    private String correctChoiceDesc;

    private List<Choice> choices;

}