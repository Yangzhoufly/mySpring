package com.fly.tx.dao;

public interface IAccDao {
    //扣钱
    public void output(String outer, Integer money);

    //放钱
    public void input(String inner, Integer money);
}
