package com.example.project1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionWithChoice {
    private Question question;
    private List<Choice> choices;
    private int categoryId;
}
