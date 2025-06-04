package com.example.project1.dao;


import com.example.project1.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminUsersViewDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setUserActiveStatus(int userId, boolean isActive) {
        String sql = "UPDATE User SET is_active = ? WHERE user_id = ?";
        jdbcTemplate.update(sql, isActive, userId);
    }

    public List<User> getAllUsers() {
        String sql = "SELECT user_id, email, firstname, lastname, is_active, is_admin FROM User";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            User user = new User();
            user.setUserId(rs.getInt("user_id"));
            user.setEmail(rs.getString("email"));
            user.setFirstname(rs.getString("firstname"));
            user.setLastname(rs.getString("lastname"));
            user.setActive(rs.getBoolean("is_active"));
            user.setAdmin(rs.getBoolean("is_admin"));
            return user;
        });
    }
}