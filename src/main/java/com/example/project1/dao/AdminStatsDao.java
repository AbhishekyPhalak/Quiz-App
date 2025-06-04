package com.example.project1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class AdminStatsDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public HashMap <String, String> getAdminsStats() {
        String sql = "SELECT (SELECT COUNT(user_id) FROM User WHERE is_admin = false) AS count_of_users, (SELECT COUNT(quiz_id) FROM Quiz) AS count_of_quiz, (SELECT c.name FROM Category c JOIN Quiz q ON c.category_id = q.category_id GROUP BY c.category_id, c.name ORDER BY COUNT(q.quiz_id) DESC LIMIT 1) AS most_popular_category";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            HashMap<String, String> stats = new HashMap<>();
            stats.put("count_of_users", rs.getString("count_of_users"));
            stats.put("count_of_quiz", rs.getString("count_of_quiz"));
            stats.put("most_popular_category", rs.getString("most_popular_category"));
            return stats;
        });
    }
}
