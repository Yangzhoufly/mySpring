package com.fly.aspect.service;


import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
    public void addUser() {
        System.out.println("WorkerServiceImpl 添加worker");
    }

    public void updateUser() {
        System.out.println("WorkerServiceImpl 更新worker");

    }

    public void deleteUser() {
        System.out.println("WorkerServiceImpl 删除worker");
        int a = 1 / 0;
    }

    public String userInfo(String name) {
        System.out.println("runing");
        return "hello " + name;
    }
}
