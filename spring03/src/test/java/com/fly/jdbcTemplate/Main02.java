package com.fly.jdbcTemplate;

import com.fly.jdbcTemplate.bean.User;
import com.fly.jdbcTemplate.dao.UserDao;
import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


public class Main02 {
    /*
    测试 jdbcTemplate
     */
    @Test
    public void jdbcTemplate() {
        //1.创建数据源\dbcp的连接池
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        //2.创建jdbcTemplate
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update("update user set name = ? where id = ?","han",2);
    }

    /*
测试 使用注解的 aspectJ
 */
    @Test
    public void aspectJ() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans02.xml");
        UserDao userDao = context.getBean(UserDao.class);

        User user = new User();
        user.setId(4);
        user.setName("zhang");
        user.setBalance(63);
        user.setPassword("1255");

        userDao.addUser(user);
    }
}
