package com.fly.tx;


import com.fly.tx.service.IAccService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main05 {
    /*
测试 转账案例  管理事务的代理工厂bean TransactionProxyFactoryBean
通过代理对象
 */
    @Test
    public void proxyService() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans06.xml");

        IAccService accService = (IAccService) context.getBean("proxyService");

        accService.transfer("zhou", "han", 100);
    }



}
