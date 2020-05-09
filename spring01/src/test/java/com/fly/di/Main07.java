package com.fly.di;


import com.fly.annotation.ListNode;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main07 {

    @Test
    public void test1(){

        //注解来取代xml中bean的配置
        /**
         * 1.Spring默认情况下注解不生效，开启注解功能
         * 2.如何开启spring注解功能？
         *   在.xml中配置下面两行代码
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("beans7.xml");

        /*
        1.如果@Component没配置id,通过类型获取
        IUserService service = (IUserService) context.getBean(IUserServiceImpl.class);
        2.这个类型可以是接口，还可以是实现类
         IUserService service = (IUserService) context.getBean(IUserService.class);

        如果@Component("userService),配置了id，就可以通过id来获取
        IUserService service = (IUserService) context.getBean("userService");
        */

        ListNode node1 = context.getBean(ListNode.class);
        System.out.println(node1);

        ListNode node2 = (ListNode) context.getBean("listNode");
        System.out.println(node2);


    }
}
