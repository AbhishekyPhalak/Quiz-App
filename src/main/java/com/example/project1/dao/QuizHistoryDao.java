package com.example.project1.dao;

import com.example.project1.domain.QuizHistory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuizHistoryDao {

    private final JdbcTemplate jdbcTemplate;

    public QuizHistoryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<QuizHistory> getQuizHistoryByUserId(int userId) {
        String sql = "SELECT q.quiz_id, q.time_start AS taken_at, u.firstname AS first_name, u.lastname AS last_name FROM Quiz q JOIN User u ON q.user_id = u.user_id WHERE q.user_id = ?";

        return jdbcTemplate.query(sql, new Object[]{userId}, (rs, rowNum) -> {
            QuizHistory history = new QuizHistory();
            history.setQuizId(rs.getLong("quiz_id"));
            history.setFirstName(rs.getString("first_name"));
            history.setLastName(rs.getString("last_name"));
            history.setTakenAt(rs.getTimestamp("taken_at").toString());
            return history;
        });
    }
}
