package com.example.project1.service;

import com.example.project1.dao.AdminQuizResultsDao;
import com.example.project1.domain.AdminQuizResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminQuizResultsService {

    @Autowired
    private AdminQuizResultsDao quizResultsDao;

    public List<AdminQuizResultDTO> fetchAllQuizResults() {
        return quizResultsDao.getAllQuizResults();
    }

    public List<AdminQuizResultDTO> fetchFilteredResults(String category, String userId) {
        return quizResultsDao.getFilteredQuizResults(category, userId);
    }
}