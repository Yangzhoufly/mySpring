package com.fly.service;

public class UserServiceImpl implements IUserService {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add() {
        System.out.println("创建用户:"+name);
    }

    public UserServiceImpl() {
        System.out.println("初始化UserServiceImpl");
    }
}
