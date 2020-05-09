package com.fly.aop;


import com.fly.proxy.jdk.service.IWorkerService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main03 {

    /*
    测试 aspectJ
     */
    @Test
    public void aspectJ() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans11.xml");

        IWorkerService serviceProxy = (IWorkerService) context.getBean("workerService");
        String res = serviceProxy.userInfo("han");
        System.out.println(res);
    }


    /*
    测试 aspectJ 异常通知
     */
    @Test
    public void aspectJ2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans11.xml");
        IWorkerService serviceProxy = (IWorkerService) context.getBean("workerService");
        serviceProxy.deleteWorker();
    }

}
