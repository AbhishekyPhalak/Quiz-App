package com.example.project1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionUpdateDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void updateQuestionDescription(int questionId, String description) {
        String sql = "UPDATE question SET description = ? WHERE question_id = ?";
        jdbcTemplate.update(sql, description, questionId);
    }

    public void updateChoice(int choiceId, String description, boolean isCorrect) {
        String sql = "UPDATE choice SET description = ?, is_correct = ? WHERE choice_id = ?";
        jdbcTemplate.update(sql, description, isCorrect, choiceId);
    }
}
