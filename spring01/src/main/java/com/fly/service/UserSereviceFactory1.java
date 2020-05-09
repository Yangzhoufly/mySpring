package com.fly.service;
/*
 使用静态工厂方法实例化
 */
public class UserSereviceFactory1 {
    public static IUserService createUserService(){
        System.out.println(" 使用静态工厂方法实例化");
        return new UserServiceImpl();
    }
}
