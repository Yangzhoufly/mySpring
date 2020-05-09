package com.fly.jdbcTemplate.dao;

import com.fly.jdbcTemplate.bean.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class UserDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addUser(User user) {
        jdbcTemplate.update("insert into user (id,name,balance,password) values (?,?,?,?)",
                user.getId(), user.getName(), user.getBalance(), user.getPassword());
    }

}
