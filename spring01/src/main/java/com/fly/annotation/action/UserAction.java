package com.fly.annotation.action;

import com.fly.annotation.Bean.User;
import com.fly.annotation.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;


@Controller //web层
public class UserAction {
    //@Autowired //Spring会自动注入，可以不用get，set方法了
    //@Qualifier("userService01") //根据指定ID注入属性

    @Resource(name = "userService02") //相当于上面两行的效果
    private IUserService service;

    public UserAction() {
        System.out.println("UserAction 构造方法 ");
    }
    public void add(User user) {
        service.add(user);
        System.out.println("UserAction 创建用户:" + user);
    }
}
