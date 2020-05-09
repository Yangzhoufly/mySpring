package com.fly.annotation.service;


import com.fly.annotation.Bean.User;
import com.fly.annotation.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userService01") //Service层
public class UserServiceImpl implements IUserService {

    @Autowired //Spring会自动注入
    private IUserDao userDao;

    public UserServiceImpl() {
        System.out.println("UserServiceImpl01 构造方法 ");
    }

    @Override
    public void add(User user) {
        userDao.add(user);
        System.out.println("UserServiceImpl 01 创建用户:" + user);
    }
}
