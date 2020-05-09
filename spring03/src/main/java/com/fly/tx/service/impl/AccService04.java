package com.fly.tx.service.impl;

import com.fly.tx.dao.IAccDao;
import com.fly.tx.service.IAccService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*
测试 转账案例 事务 通过注解配置
 */
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
public class AccService04 implements IAccService {

    private IAccDao accDao;

    public void setAccDao(IAccDao accDao) {
        this.accDao = accDao;
    }

    @Override
    public void transfer(String outer, String inner, Integer money) {
        accDao.output(outer, money);
        //int a = 1 / 0;
        accDao.input(inner, money);
    }
}
