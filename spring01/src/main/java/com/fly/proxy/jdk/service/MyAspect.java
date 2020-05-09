package com.fly.proxy.jdk.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/*
切面类：增强代码与切入点的结合
 */
public class MyAspect {
    public void before() {
        System.out.println("前置通知");
    }

    public void after() {
        System.out.println("后置通");
    }

    public void afterReturning(JoinPoint joinPoint, Object ret) {
        System.out.println("后置通知：" + joinPoint.getSignature().getName() + "  return：" + ret);
    }


    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around---前");
        Object res = joinPoint.proceed();
        System.out.println("around---后");
        return res;
    }

    public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
        System.out.println("异常通知：" + joinPoint.getSignature().getName());
        System.out.println(throwable.getMessage());
    }
}
