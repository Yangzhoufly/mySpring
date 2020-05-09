package com.fly.jdbcTemplate.dao;

import com.fly.jdbcTemplate.bean.User;
import org.springframework.jdbc.core.support.JdbcDaoSupport;



public class UserDao02  extends JdbcDaoSupport {

    public void addUser(User user) {

        super.getJdbcTemplate().update("insert into user (id,name,balance,password) values (?,?,?,?)",
                user.getId(), user.getName(), user.getBalance(), user.getPassword());
    }

}
