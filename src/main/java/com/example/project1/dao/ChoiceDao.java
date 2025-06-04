package com.example.project1.dao;

import com.example.project1.domain.Choice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChoiceDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Choice> getChoicesByQuestionId(int question_id){
        String sql = "SELECT * FROM Choice WHERE question_id = ?";
        return jdbcTemplate.query(sql,new Object[]{question_id},(rs,rowNum)->{
            Choice choice = new Choice();
            choice.setChoiceId(rs.getInt("choice_id"));
            choice.setQuestionId(rs.getInt("question_id"));
            choice.setDescription(rs.getString("description"));
            choice.setCorrect(rs.getBoolean("is_correct"));
            return choice;
        });
    }

}
