package com.fly.tx;


import com.fly.tx.service.IAccService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main04 {
    /*
测试 转账案例 普通 没有事务管理
 */
    @Test
    public void transfer() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans05.xml");

        IAccService accService = (IAccService) context.getBean("accService");

        accService.transfer("zhou", "han", 100);
    }

    /*
测试 转账案例 有事务管理 手动xml配置 test
*/
    @Test
    public void jdbcDaoSupport() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans05.xml");

        IAccService accService = (IAccService) context.getBean("accService02");

        accService.transfer("zhou", "han", 100);
    }


}
