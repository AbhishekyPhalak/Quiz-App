package com.example.project1.dao;

import com.example.project1.domain.Choice;
import com.example.project1.domain.QuizQuestionResult;
import com.example.project1.domain.QuizResultsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuizResultsDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public QuizResultsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public QuizResultsData fetchQuizResults(int quizId, int userId) {

        String quizSql = "SELECT q.quiz_id, q.name, q.time_start, q.time_end, c.name AS category_name, u.firstname AS user_firstname, u.lastname AS user_lastname FROM Quiz q JOIN Category c ON q.category_id = c.category_id JOIN User u ON q.user_id = u.user_id WHERE q.quiz_id = ? AND q.user_id = ?";

        QuizResultsData quizResultsData = jdbcTemplate.queryForObject(
                quizSql,
                new Object[]{ quizId, userId },
                (rs, rowNum) -> {
                    QuizResultsData data = new QuizResultsData();
                    data.setQuizId(rs.getInt("quiz_id"));
                    data.setQuizName(rs.getString("name"));
                    data.setStartTime(rs.getTimestamp("time_start").toLocalDateTime());
                    data.setEndTime(rs.getTimestamp("time_end").toLocalDateTime());
                    data.setCategoryName(rs.getString("category_name"));
                    data.setUserFirstName(rs.getString("user_firstname"));
                    data.setUserLastName(rs.getString("user_lastname"));
                    return data;
                }
        );

        String questionsSql = "SELECT qn.question_id, qn.description AS question_desc, uc.choice_id AS user_choice_id, uc.description AS user_choice_desc, cc.choice_id AS correct_choice_id, cc.description AS correct_choice_desc FROM QuizQuestion qq JOIN Question qn ON qq.question_id = qn.question_id JOIN Choice uc ON qq.user_choice_id = uc.choice_id JOIN Choice cc ON cc.question_id = qn.question_id AND cc.is_correct = true WHERE qq.quiz_id = ?";

        List<QuizQuestionResult> questionResults = jdbcTemplate.query(
                questionsSql,
                new Object[]{ quizId },
                (rs, rowNum) -> {
                    QuizQuestionResult result = new QuizQuestionResult();
                    result.setQuestionId(rs.getInt("question_id"));
                    result.setQuestionDesc(rs.getString("question_desc"));
                    result.setUserChoiceId(rs.getInt("user_choice_id"));
                    result.setUserChoiceDesc(rs.getString("user_choice_desc"));
                    result.setCorrectChoiceId(rs.getInt("correct_choice_id"));
                    result.setCorrectChoiceDesc(rs.getString("correct_choice_desc"));
                    return result;
                }
        );

        String allChoicesSql = "SELECT choice_id, description, is_correct FROM Choice WHERE question_id = ?";

        for (QuizQuestionResult qr : questionResults) {
            List<Choice> allChoices = jdbcTemplate.query(
                    allChoicesSql,
                    new Object[]{ qr.getQuestionId() },
                    (rs, rowNum) -> {
                        Choice c = new Choice();
                        c.setChoiceId(rs.getInt("choice_id"));
                        c.setDescription(rs.getString("description"));
                        c.setCorrect(rs.getBoolean("is_correct"));
                        return c;
                    }
            );
            qr.setChoices(allChoices);
        }

        quizResultsData.setQuestionResults(questionResults);
        return quizResultsData;
    }
}
