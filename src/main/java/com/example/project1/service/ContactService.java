package com.example.project1.service;

import com.example.project1.dao.ContactDao;
import com.example.project1.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactDao contactDao;

    public void addContact(String subject, String message, String email) {
        Contact contact = new Contact();
        contact.setSubject(subject);
        contact.setMessage(message);
        contact.setEmail(email);
        contactDao.addContact(contact);
    }
}
