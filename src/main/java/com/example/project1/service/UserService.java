package com.example.project1.service;

import com.example.project1.dao.UserDao;
import com.example.project1.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public boolean RegisterUser(User user) {
        user.setActive(true);
        user.setAdmin(false);

        try{
            userDao.saveUser(user);
            return true;
        }
        catch(Exception e){
            if(e.getMessage().contains("Duplicate entry")) {
                System.out.println("User with this email already exists.");
            } else {
                System.out.println("An error occurred while registering the user: " + e.getMessage());
            }
            return false;
        }
    }
}
