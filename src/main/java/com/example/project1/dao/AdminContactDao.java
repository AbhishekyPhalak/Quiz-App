package com.example.project1.dao;

import com.example.project1.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminContactDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Contact> getAllContacts() {
        String sql = "SELECT subject, message, email, time FROM Contact";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Contact contact = new Contact();
            contact.setSubject(rs.getString("subject"));
            contact.setMessage(rs.getString("message"));
            contact.setEmail(rs.getString("email"));
            contact.setTime(rs.getTimestamp("time").toLocalDateTime());
            return contact;
        });
    }
}
