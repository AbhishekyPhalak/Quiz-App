package com.example.project1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionPrivilegesDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void updateQuestionStatus(int questionId, boolean isActive) {
        String sql = "UPDATE Question SET is_active = ? WHERE question_id = ?";
        jdbcTemplate.update(sql, isActive, questionId);
    }
}