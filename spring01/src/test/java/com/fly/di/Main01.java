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

public class Main01 {

    //以前
    @Test
    public void testFun() {
        IUserService user = new UserServiceImpl();
        user.add();
    }

    @Test
    public void testFromBean() {
        //1、加载beans.xml配置文件，内部会创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        IUserService userService01 = (IUserService) context.getBean("userService");
        IUserService userService02 = (IUserService) context.getBean("userService");
        System.out.println(userService01 == userService02);
        System.out.println(userService01.getClass());
        System.out.println(userService02.getClass());

        userService02.add();
    }
    //Spring容器加载有3种方式
    @Test
    public void testLoad() {
        /*
        第一种:ClassPathXmlApplicationContext ClassPath类路径加载，指的就是classes路径
        最常用,spring的配置文件路径以后就直接放在src
        还没有getBean的时候就会初始化
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    }

    @Test
    public void testLoad2() {
        //第二种方式：文件系统路径获得配置文件【绝对路径】
        ApplicationContext context2 = new FileSystemXmlApplicationContext("E:\\file\\code\\IDEA\\Spring_learn\\spring01\\src\\main\\resources\\beans.xml");
    }

    @Test
    public void testCompare() {
        //第三种方式:使用BeanFactory
        //BeanFactory 采取延迟加载，第一次getBean时才会初始化Bean
        String path = "E:\\file\\code\\IDEA\\Spring_learn\\spring01\\src\\main\\resources\\beans.xml";
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource(path));
    }


}
