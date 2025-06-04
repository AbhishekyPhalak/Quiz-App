package com.example.project1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private int questionId;
    private int categoryId;
    private String description;
    private boolean active;
    private List<Choice> choices;
    private String categoryName;
}