package com.example.project1.service;

import com.example.project1.dao.LoginDao;
import com.example.project1.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    LoginDao loginDao;

    public User validateUser(String email, String password) {
        return loginDao.getUserByEmailAndPassword(email, password);
    }
}
