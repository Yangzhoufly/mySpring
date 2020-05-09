package com.fly.di;


import com.fly.annotation.Bean.User;
import com.fly.annotation.action.UserAction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main08 {
    /*
    测试 没有使用注解的dao，service
     */
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans8.xml");
        UserAction userAction = (UserAction) context.getBean("userAction");
        userAction.add(new User("yangzhoufly", 25));
    }



    /*
    测试  使用注解配置的 dao，service
     */
    @Test
    public void annotation() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans7.xml");
        UserAction userAction = (UserAction) context.getBean(UserAction.class);

        System.out.println("\n====\n");

        userAction.add(new User("yangzhoufly", 66));

        //关闭容器，是为了看到  @PreDestroy //相当于 xml 中的  destroy-method
        context.getClass().getMethod("close").invoke(context);
    }
}
