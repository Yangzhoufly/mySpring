package com.fly.aspect;

import com.fly.aspect.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main01 {
    /*
    测试 使用注解的 aspectJ
     */
    @Test
    public void aspectJ() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans01.xml");

        UserService serviceProxy = (UserService) context.getBean("userService");
        //String res = serviceProxy.userInfo("han");
        //System.out.println(res);

        serviceProxy.deleteUser();
    }
}
