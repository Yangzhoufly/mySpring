package com.fly.di;

import com.fly.service.IUserService;
import com.fly.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

/*
测试装配bean的三种方式
bean的作用域
 */
public class Main02 {


    @Test
    public void testFromBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
        IUserService user1 = (IUserService) context.getBean("userService2");
    }

    @Test
    public void testFromBean2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
        IUserService userService01 = (IUserService) context.getBean("userService3");
        userService01.add();
    }

    @Test
    public void testScopeSingleton() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
        IUserService user1 = (IUserService) context.getBean("userService1");
        IUserService user2 = (IUserService) context.getBean("userService1");

        System.out.println(user1 == user2);
    }

    @Test
    public void testScopePrototype() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
        IUserService user1 = (IUserService) context.getBean("userService3");
        IUserService user2 = (IUserService) context.getBean("userService3");

        System.out.println(user1 == user2);
    }


}
