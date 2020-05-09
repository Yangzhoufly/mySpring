package com.fly.di;

import com.fly.model.User;
import com.fly.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;

/*
测试 bean的生命周期
 */
public class Main03 {


    @Test
    public void testLife() throws Exception {
        System.out.println("测试bean的生命周期\n\n");

        ApplicationContext context = new ClassPathXmlApplicationContext("beans3.xml");
        User user1 = (User) context.getBean("user");

        user1.call();

        //关闭容器
        context.getClass().getMethod("close").invoke(context);
    }
}
