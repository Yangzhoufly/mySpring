package com.fly.proxy.jdk.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
测试 自己实现jdk代理AOP
 */
public class WorkerServiceFactory {
    public static IWorkerService createWorkerService() {
        //1.创建目标对象target
        IWorkerService workerService = new WorkerServiceImpl();

        //2.声明切面类对象
        MyAspect aspect = new MyAspect();

        //3.把切面类2个方法 应用 目标类
        //3.1 创建JDK代理,拦截方法

        IWorkerService proxy =
                (IWorkerService) Proxy.newProxyInstance(
                        WorkerServiceFactory.class.getClassLoader(), //需要类加载器
                        workerService.getClass().getInterfaces(), //需要接口
                        new InvocationHandler() {
                            @Override
                            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                                aspect.before();
                                Object returnVal = method.invoke(workerService, args);
                                aspect.after();

                                return returnVal;
                            }
                        });

        return proxy;
    }
}
