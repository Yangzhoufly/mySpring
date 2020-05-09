package com.fly.aop;


import com.fly.proxy.jdk.service.IWorkerService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main02 {

    /*
    测试 获取spring代理对象、半自动
     */
    @Test
    public void testSpringAop() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans9.xml");

        IWorkerService serviceProxy = (IWorkerService) context.getBean("serviceProxy");
        String res = serviceProxy.userInfo("zhou");
        System.out.println(res);
    }

    /*
测试 获取spring代理对象、全自动
 */
    @Test
    public void testSpringAop02() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans10.xml");

        IWorkerService serviceProxy = (IWorkerService) context.getBean("userService");
        String res = serviceProxy.userInfo("zhou");
        System.out.println(res);
    }


}
