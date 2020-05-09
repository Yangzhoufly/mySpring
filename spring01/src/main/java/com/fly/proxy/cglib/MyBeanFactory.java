package com.fly.proxy.cglib;


import com.fly.proxy.jdk.service.MyAspect;
import com.fly.proxy.jdk.service.WorkerServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/*
测试 自己实现cglib代理AOP
 */
public class MyBeanFactory {
    public static WorkerServiceImpl createWorkerServiceCGlib() {
        //1.创建目标对象target
        WorkerServiceImpl workerService = new WorkerServiceImpl();

        //2.声明切面类对象
        MyAspect aspect = new MyAspect();

        //3、创建增强对象
        Enhancer enhancer = new Enhancer();

        //设置父类
        enhancer.setSuperclass(workerService.getClass());

        // 设置回调函数
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] agrs, MethodProxy methodProxy) throws Throwable {

                //proxy是生成的代理子类，methodProxy子类的方法
                aspect.before();
                //放行方法1
                Object result = method.invoke(workerService, agrs);
                //放行方法2、解耦了
                Object res = methodProxy.invokeSuper(proxy, agrs);

                System.out.println(workerService.getClass());
                System.out.println(proxy.getClass());
                System.out.println(proxy instanceof WorkerServiceImpl);
                aspect.after();

                return res;
            }
        });

        WorkerServiceImpl workerService1 = (WorkerServiceImpl) enhancer.create();
        return workerService1;
    }
}
