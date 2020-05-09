package com.fly.proxy.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/*
切面类：增强代码与切入点的结合
 */
public class  MyAspect implements MethodInterceptor {
    public void before(){
        System.out.println("开启事务");
    }

    public void after(){
        System.out.println("关闭事务");
    }

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        before();
        Object res = methodInvocation.proceed();
        after();

        return res;
    }
}
