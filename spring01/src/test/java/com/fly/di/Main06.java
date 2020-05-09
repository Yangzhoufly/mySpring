package com.fly.di;

import com.fly.model.TreeNode;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
测试 综合使用
 */
public class Main06 {


    @Test
    public void testSpEL() {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans6.xml");
        TreeNode root = (TreeNode) context.getBean("root");

        System.out.println(root.getVal()+" "+root.getLeft().getVal()+" "+root.getRight().getVal());
    }

}
