package com.example.project1.dao;

import com.example.project1.domain.Choice;
import com.example.project1.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class QuestionManagementDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Question> getAllQuestionsWithChoices() {

        String sql = "SELECT q.question_id, q.description AS q_desc, q.is_active, c.name AS category_name, ch.choice_id, ch.description AS ch_desc, ch.is_correct FROM Question q JOIN Category c ON q.category_id = c.category_id LEFT JOIN Choice ch ON q.question_id = ch.question_id ORDER BY q.question_id, ch.choice_id";

        Map<Integer, Question> questionMap = new LinkedHashMap<>();

        jdbcTemplate.query(sql, rs -> {
            int qid = rs.getInt("question_id");

            Question question = questionMap.computeIfAbsent(qid, id -> {
                Question q = new Question();
                q.setQuestionId(id);
                try {
                    q.setDescription(rs.getString("q_desc"));
                    q.setActive(rs.getBoolean("is_active"));
                    q.setCategoryName(rs.getString("category_name"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                q.setChoices(new ArrayList<>());
                return q;
            });

            int choiceId = rs.getInt("choice_id");
            if (choiceId > 0) {
                Choice choice = new Choice();
                choice.setChoiceId(choiceId);
                choice.setDescription(rs.getString("ch_desc"));
                choice.setCorrect(rs.getBoolean("is_correct"));
                question.getChoices().add(choice);
            }
        });

        return new ArrayList<>(questionMap.values());
    }
}