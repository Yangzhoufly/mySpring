package com.fly.di;

import com.fly.model.Student;
import com.fly.model.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
测试 依赖注入Bean属性(xml)
 */
public class Main04 {


    @Test
    public void testDI() {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans4.xml");
        Student stu = (Student) context.getBean("stu");

        System.out.println(stu);
    }

    @Test
    public void testDI2() {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans4.xml");
        Student stu = (Student) context.getBean("stu4");

        System.out.println(stu);
    }

    @Test
    public void testDI3() {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans4.xml");
        Student stu = (Student) context.getBean("stu5");

        System.out.println(stu);
    }
}
