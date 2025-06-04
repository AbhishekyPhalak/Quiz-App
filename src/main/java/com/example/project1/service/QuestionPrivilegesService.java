package com.example.project1.service;

import com.example.project1.dao.QuestionPrivilegesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionPrivilegesService {

    @Autowired
    private QuestionPrivilegesDao questionPrivilegesDao;

    public void setQuestionActiveStatus(int questionId, boolean isActive) {
        questionPrivilegesDao.updateQuestionStatus(questionId, isActive);
    }
}