package com.fly.tx.service;

public interface IAccService {
    /**
     *
     * @param outer 转出的账号
     * @param inner 转入的账号
     * @param money 转账金额
     */
    public void transfer(String outer, String inner, Integer money);
}
