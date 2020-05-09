package com.fly.di;

import com.fly.model.Customer;
import com.fly.model.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
测试 SpEL表达式【了解】
 */
public class Main05 {


    @Test
    public void testSpEL() {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans5.xml");
        Customer customer = (Customer) context.getBean("customer");

        System.out.println(customer);
    }

}
