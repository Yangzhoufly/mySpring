package com.fly.tx.dao.impl;

import com.fly.tx.dao.IAccDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccDao extends JdbcDaoSupport implements IAccDao {
    @Override
    public void output(String outer, Integer money) {
        getJdbcTemplate().update("update acc set money = money - ? where username = ?", money, outer);
    }

    @Override
    public void input(String inner, Integer money) {
        getJdbcTemplate().update("update acc set money = money + ? where username = ?", money, inner);
    }
}
