package com.example.project1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizQuestion {
    private int qqId;
    private int quizId;
    private int questionId;
    private int userChoiceId;
}