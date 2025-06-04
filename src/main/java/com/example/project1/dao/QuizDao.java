package com.example.project1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class QuizDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer insertQuiz(int userId, int categoryId, String name, Timestamp timeStart, Timestamp timeEnd) {
        String sql = "INSERT INTO Quiz (user_id, category_id, name, time_start, time_end) VALUES (?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, userId);
            ps.setInt(2, categoryId);
            ps.setString(3, name);
            ps.setTimestamp(4, timeStart);
            ps.setTimestamp(5, timeEnd);
            return ps;
        }, keyHolder);

        return keyHolder.getKey().intValue();
    }
}