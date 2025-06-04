package com.example.project1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizHistory {
    private String firstName;
    private String lastName;
    private String takenAt;
    private Long quizId;
}
