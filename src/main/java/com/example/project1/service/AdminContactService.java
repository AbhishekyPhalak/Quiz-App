package com.example.project1.service;

import com.example.project1.dao.AdminContactDao;
import com.example.project1.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminContactService {
    @Autowired
    private AdminContactDao adminContactDao;

    public List<Contact> getAllContacts() {
        return adminContactDao.getAllContacts();
    }
}
