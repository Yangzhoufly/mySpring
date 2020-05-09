package com.fly.service;
/*
使用实例工厂方法实例化
 */
public class UserSereviceFactory2 {

    public IUserService createUserService(){
        System.out.println("使用实例工厂方法实例化");
        return new UserServiceImpl();
    }
}
