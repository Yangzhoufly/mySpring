package com.fly.jdbcTemplate;

import com.fly.jdbcTemplate.bean.User;
import com.fly.jdbcTemplate.dao.UserDao02;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main03 {
    /*
测试 使用JdbcDaoSupport
 */
    @Test
    public void jdbcDaoSupport() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans03.xml");
        UserDao02 userDao = context.getBean(UserDao02.class);

        User user = new User();
        user.setId(7);
        user.setName("zhang");
        user.setBalance(63);
        user.setPassword("1255");

        userDao.addUser(user);
    }

    /*
测试 从properties文件中读取属性
 */
    @Test
    public void properties() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans04.xml");
        UserDao02 userDao = context.getBean(UserDao02.class);

        User user = new User();
        user.setId(9);
        user.setName("zhang");
        user.setBalance(63);
        user.setPassword("1255");

        userDao.addUser(user);
    }
}
