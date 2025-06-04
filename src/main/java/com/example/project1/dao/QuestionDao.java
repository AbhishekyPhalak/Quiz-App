package com.example.project1.dao;

import com.example.project1.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Question> getQuestionByCategoryId(int categoryId){
        String sql = "SELECT * FROM Question WHERE category_id= ? AND is_active = true ORDER BY RAND() LIMIT 3";
        return jdbcTemplate.query(sql, new Object[]{categoryId}, (rs, rowNum)->{
           Question question = new Question();
              question.setQuestionId(rs.getInt("question_id"));
                question.setCategoryId(rs.getInt("category_id"));
                question.setDescription(rs.getString("description"));
                question.setActive(rs.getBoolean("is_active"));
                return question;
        });
    }
}
