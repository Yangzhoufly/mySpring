package com.fly.tx.service.impl;

import com.fly.tx.dao.IAccDao;
import com.fly.tx.service.IAccService;

public class AccService implements IAccService {


    private IAccDao accDao;


    public void setAccDao(IAccDao accDao) {
        this.accDao = accDao;
    }

    @Override
    public void transfer(String outer, String inner, Integer money) {
        accDao.output(outer,money);
        int a = 1/0;
        accDao.input(inner,money);
    }
}
