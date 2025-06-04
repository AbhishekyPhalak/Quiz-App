package com.example.project1.dao;

import com.example.project1.domain.AdminQuizResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminQuizResultsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<AdminQuizResultDTO> getAllQuizResults() {
        String sql = "SELECT q.quiz_id, q.name AS quiz_name, q.time_start, q.time_end, c.name AS category_name, u.user_id, CONCAT(u.firstname, ' ', u.lastname) AS user_full_name, COUNT(qq.question_id) AS total_questions, SUM(CASE WHEN qq.user_choice_id IN (SELECT choice_id FROM Choice WHERE is_correct = TRUE AND question_id = qq.question_id) THEN 1 ELSE 0 END) * 10 AS score FROM Quiz q JOIN Category c ON q.category_id = c.category_id JOIN User u ON q.user_id = u.user_id JOIN QuizQuestion qq ON q.quiz_id = qq.quiz_id GROUP BY q.quiz_id, q.name, q.time_start, q.time_end, c.name, u.user_id, u.firstname, u.lastname ORDER BY q.time_start DESC;";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            int quizId = rs.getInt("quiz_id");
            int userId = rs.getInt("user_id");
//            System.out.println("Fetched result - quizId: " + quizId + ", userId: " + userId);

            return new AdminQuizResultDTO(
                    quizId,
                    rs.getString("quiz_name"),
                    rs.getTimestamp("time_start"),
                    rs.getTimestamp("time_end"),
                    rs.getString("category_name"),
                    rs.getString("user_full_name"),
                    rs.getInt("total_questions"),
                    rs.getInt("score"),
                    userId
            );
        });

    }

    public List<AdminQuizResultDTO> getFilteredQuizResults(String category, String userId) {
        StringBuilder sql = new StringBuilder(
                "SELECT q.quiz_id, q.name AS quiz_name, q.time_start, q.time_end, " +
                        "c.name AS category_name, u.user_id, CONCAT(u.firstname, ' ', u.lastname) AS user_full_name, " +
                        "COUNT(qq.question_id) AS total_questions, " +
                        "SUM(CASE WHEN qq.user_choice_id IN (SELECT choice_id FROM Choice WHERE is_correct = TRUE AND question_id = qq.question_id) THEN 1 ELSE 0 END) * 10 AS score " +
                        "FROM Quiz q " +
                        "JOIN Category c ON q.category_id = c.category_id " +
                        "JOIN User u ON q.user_id = u.user_id " +
                        "JOIN QuizQuestion qq ON q.quiz_id = qq.quiz_id "
        );

        boolean hasCategory = category != null && !category.isEmpty();
        boolean hasUserId = userId != null && !userId.isEmpty();

        if (hasCategory || hasUserId) {
            sql.append("WHERE ");
            if (hasCategory) {
                sql.append("c.name = ? ");
            }
            if (hasUserId) {
                if (hasCategory) sql.append("AND ");
                sql.append("u.user_id = ? ");
            }
        }

        sql.append("GROUP BY q.quiz_id, q.name, q.time_start, q.time_end, c.name, u.user_id, u.firstname, u.lastname ");
        sql.append("ORDER BY q.time_start DESC");

        List<Object> params = new java.util.ArrayList<>();
        if (hasCategory) params.add(category);
        if (hasUserId) params.add(Integer.parseInt(userId));

        return jdbcTemplate.query(sql.toString(), params.toArray(), (rs, rowNum) -> new AdminQuizResultDTO(
                rs.getInt("quiz_id"),
                rs.getString("quiz_name"),
                rs.getTimestamp("time_start"),
                rs.getTimestamp("time_end"),
                rs.getString("category_name"),
                rs.getString("user_full_name"),
                rs.getInt("total_questions"),
                rs.getInt("score"),
                rs.getInt("user_id")
        ));
    }



}
