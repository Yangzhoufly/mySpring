package com.fly.tx.service.impl;

import com.fly.tx.dao.IAccDao;
import com.fly.tx.service.IAccService;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/*
 有事务管理 手动xml配置
 */
public class AccService02 implements IAccService {

    private IAccDao accDao;

    public void setAccDao(IAccDao accDao) {
        this.accDao = accDao;
    }

    //Spring 配置事务模板
    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    @Override
    public void transfer(String outer, String inner, Integer money) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                accDao.output(outer,money);
                //int a = 1/0;
                accDao.input(inner,money);
            }
        });
    }
}
