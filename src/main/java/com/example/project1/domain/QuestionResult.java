package com.example.project1.domain;

import lombok.Data;

import java.util.List;

@Data
public class QuestionResult {
    private String questionText;
    private List<String> choices;
    private String selectedAnswer;
    private String correctAnswer;
    private boolean isCorrect;
}
