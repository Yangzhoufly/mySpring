package com.fly.annotation.dao;

import com.fly.annotation.Bean.User;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Repository //Dao层
public class UserDaoImpl implements IUserDao {


    public UserDaoImpl() {
        System.out.println("UserDaoImpl 构造方法 ");
    }

    @Override
    public void add(User user) {
        System.out.println("UserDaoImpl 添加用户" + user);
    }

    @PostConstruct  //相当于 xml 中的 init-method
    public void myInit() {
        System.out.println("dao 自定义初始化方法");
    }

    @PreDestroy //相当于 xml 中的  destroy-method
    public void myDestory() {
        System.out.println("dao 自定义销毁方法");
    }
}
