package com.example.project1.service;

import com.example.project1.dao.QuestionManagementDao;
import com.example.project1.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionManagementService {

    @Autowired
    private QuestionManagementDao dao;

    public List<Question> getAllQuestions() {
        return dao.getAllQuestionsWithChoices();
    }
}