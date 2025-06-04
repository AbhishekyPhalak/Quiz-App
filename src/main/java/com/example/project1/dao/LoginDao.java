package com.example.project1.dao;

import com.example.project1.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User getUserByEmailAndPassword(String email, String password) {
        String sql = "SELECT * FROM User WHERE email = ? AND password = ? AND is_active = TRUE";
        try{
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                    new User(
                            rs.getInt("user_id"),
                            rs.getString("email"),
                            rs.getString("password"),
                            rs.getString("firstname"),
                            rs.getString("lastname"),
                            rs.getBoolean("is_active"),
                            rs.getBoolean("is_admin")
                    ), email, password);
        }
        catch (Exception e) {
            return null;
        }
    }


}
