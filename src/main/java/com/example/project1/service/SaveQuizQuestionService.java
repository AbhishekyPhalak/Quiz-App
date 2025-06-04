package com.example.project1.service;

import com.example.project1.dao.QuizQuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SaveQuizQuestionService {
    @Autowired
    private QuizQuestionDao quizQuestionDao;

    public void saveQuizQuestions(int quizId, Map<String, String[]> paramMap) {
        quizQuestionDao.saveQuizQuestions(quizId, paramMap);
    }
}
