package com.example.project1.service;

import com.example.project1.dao.AdminStatsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AdminStatsService {

    @Autowired
    private AdminStatsDao adminStatsDao;

    public HashMap<String, String> getAdminStats() {
        return adminStatsDao.getAdminsStats();
    }
}
