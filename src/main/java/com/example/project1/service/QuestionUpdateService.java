package com.example.project1.service;

import com.example.project1.dao.QuestionUpdateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionUpdateService {

    @Autowired
    private QuestionUpdateDao questionUpdateDao;

    public void updateQuestionAndChoices(
            int questionId,
            String description,
            int choiceId1, String choice1,
            int choiceId2, String choice2,
            int choiceId3, String choice3,
            int correctChoiceId
    ) {
        questionUpdateDao.updateQuestionDescription(questionId, description);

        questionUpdateDao.updateChoice(choiceId1, choice1, choiceId1 == correctChoiceId);
        questionUpdateDao.updateChoice(choiceId2, choice2, choiceId2 == correctChoiceId);
        questionUpdateDao.updateChoice(choiceId3, choice3, choiceId3 == correctChoiceId);
    }
}