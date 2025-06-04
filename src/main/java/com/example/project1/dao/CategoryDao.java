package com.example.project1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int getQuizCategoryId(String category) {
        String sql = "SELECT category_id FROM Category WHERE name = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{category}, Integer.class);
    }
}
