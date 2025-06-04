package com.example.project1.service;

import com.example.project1.dao.QuizHistoryDao;
import com.example.project1.domain.QuizHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizHistoryService {

    @Autowired
    private QuizHistoryDao quizHistoryDao;

    public List<QuizHistory> getQuizHistory(int userId) {
        return quizHistoryDao.getQuizHistoryByUserId(userId);
    }
}
