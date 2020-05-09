package com.fly.aspect.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/*
切面类：增强代码与切入点的结合
 */

@Component("myAspect")
@Aspect
public class MyAspect {

    @Pointcut("execution(* com.fly.aspect.service.UserService.*(..))")
    public void myPointcut() {
        //用来声明一个公共的切入点
    }


    @Before("execution(* com.fly.aspect.service.UserService.*(..))")
    public void before() {
        System.out.println("前置通知");
    }

    @AfterReturning(pointcut = "myPointcut()", returning = "ret")
    public void afterReturning(JoinPoint joinPoint, Object ret) {
        System.out.println("后置通知：" + joinPoint.getSignature().getName() + "  return：" + ret);
    }


    @Around("myPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around---前");
        Object res = joinPoint.proceed();
        System.out.println("around---后");
        return res;
    }


    @After("myPointcut()")
    public void after() {
        System.out.println("最终通知");
    }

    //<aop:after-throwing method="afterThrowing" pointcut-ref="myPointcut" throwing="throwable"></aop:after-throwing>
    @AfterThrowing(pointcut = "myPointcut()", throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
        System.out.println("异常通知：" + joinPoint.getSignature().getName());
        System.out.println(throwable.getMessage());
    }
}
