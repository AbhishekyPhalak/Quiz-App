package com.example.project1.service;

import com.example.project1.dao.CategoryDao;
import com.example.project1.dao.ChoiceDao;
import com.example.project1.dao.QuestionDao;
import com.example.project1.dao.QuizDao;
import com.example.project1.domain.Choice;
import com.example.project1.domain.Question;
import com.example.project1.domain.QuestionWithChoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private ChoiceDao choiceDao;

    @Autowired
    private QuizDao quizDao;

    public List<QuestionWithChoice> getQuizData(String category) {
        int categoryId = categoryDao.getQuizCategoryId(category);
        List<Question> questions = questionDao.getQuestionByCategoryId(categoryId);
        List<QuestionWithChoice> quizData = new ArrayList<>();

        for(Question q:questions){
            int questionId = q.getQuestionId();
            List<Choice> choices = choiceDao.getChoicesByQuestionId(questionId);
            QuestionWithChoice questionWithChoice = new QuestionWithChoice(q, choices, categoryId);
            quizData.add(questionWithChoice);
        }
        return quizData;
    }

    public Integer saveQuiz(int userId, int categoryId, long timeStartMillis, long timeEndMillis) {
        Timestamp timeStart = new Timestamp(timeStartMillis);
        Timestamp timeEnd = new Timestamp(timeEndMillis);

        String quizName = "Quiz_" + System.currentTimeMillis();
        return quizDao.insertQuiz(userId, categoryId, quizName, timeStart, timeEnd);
    }

}
