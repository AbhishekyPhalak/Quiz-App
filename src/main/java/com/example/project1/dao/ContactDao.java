package com.example.project1.dao;

import com.example.project1.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ContactDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addContact(Contact contact){
        String sql = "INSERT INTO contact(subject, message, email) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, contact.getSubject(), contact.getMessage(), contact.getEmail());
    }

}
