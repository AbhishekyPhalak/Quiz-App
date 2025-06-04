package com.example.project1.dao;

import com.example.project1.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveUser(User user){
        String sql = "INSERT INTO user (email, password, firstname, lastname, is_active, is_admin) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getEmail(), user.getPassword(), user.getFirstname(), user.getLastname(), user.isActive(), user.isAdmin());
    }
}
