package com.example.project1.service;

import com.example.project1.dao.QuizResultsDao;
import com.example.project1.domain.QuizResultsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizResultsService {

    private final QuizResultsDao quizResultsDao;

    @Autowired
    public QuizResultsService(QuizResultsDao quizResultsDao) {
        this.quizResultsDao = quizResultsDao;
    }

    public QuizResultsData getQuizResults(int quizId, int userId) {
        return quizResultsDao.fetchQuizResults(quizId, userId);
    }
}
