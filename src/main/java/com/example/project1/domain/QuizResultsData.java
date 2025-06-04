package com.example.project1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizResultsData {
    private int quizId;
    private String quizName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<QuizQuestionResult> questionResults;
    private String categoryName;
    private String userFirstName;
    private String userLastName;

    public String getUserFullName() {
        return userFirstName + " " + userLastName;
    }
}