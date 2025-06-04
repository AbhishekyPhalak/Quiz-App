package com.example.project1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class AdminQuizResultDTO {
    private int quizId;
    private String quizName;
    private Timestamp timeStart;
    private Timestamp timeEnd;
    private String categoryName;
    private String userFullName;
    private int totalQuestions;
    private int score;
    private int userId;
}