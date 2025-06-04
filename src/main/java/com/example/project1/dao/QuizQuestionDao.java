package com.example.project1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class QuizQuestionDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveQuizQuestions(int quizId, Map<String, String[]> paramMap) {

        String sql = "INSERT INTO QuizQuestion (quiz_id, question_id, user_choice_id) VALUES (?, ?, ?)";

        for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
            String param = entry.getKey();

            if (param.equals("categoryId") || param.equals("timeStart")) {
                continue;
            }

            int questionId = Integer.parseInt(param);
            String[] choiceIds = entry.getValue();
            if (choiceIds.length > 0) {
                int userChoiceId = Integer.parseInt(choiceIds[0]);
                jdbcTemplate.update(sql, quizId, questionId, userChoiceId);
            }
        }
    }
}