package com.fly.tx;


import com.fly.tx.service.IAccService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main06 {
    /*
测试 转账案例  基本AOP的事务配置【掌握】 基于xml
 */
    @Test
    public void txAOPXML() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans07.xml");

        IAccService accService = (IAccService) context.getBean("accService");

        accService.transfer("zhou", "han", 100);
    }

    /*
测试 转账案例  基本AOP的事务配置【掌握】 基于注解
*/
    @Test
    public void txAOP() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans08.xml");

        IAccService accService = (IAccService) context.getBean("accService");

        accService.transfer("zhou", "han", 100);
    }

}
