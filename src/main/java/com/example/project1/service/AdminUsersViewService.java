package com.example.project1.service;

import com.example.project1.dao.AdminUsersViewDao;
import com.example.project1.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUsersViewService {

    @Autowired
    private AdminUsersViewDao adminUsersViewDao;

    public List<User> getAllUsers() {
        return adminUsersViewDao.getAllUsers();
    }

    public void setUserActiveStatus(int userId, boolean isActive) {
        adminUsersViewDao.setUserActiveStatus(userId, isActive);
    }
}