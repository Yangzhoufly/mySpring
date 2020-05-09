package com.fly.aop;

import com.fly.proxy.cglib.MyBeanFactory;
import com.fly.proxy.jdk.service.IWorkerService;
import com.fly.proxy.jdk.service.WorkerServiceFactory;
import com.fly.proxy.jdk.service.WorkerServiceImpl;
import org.junit.Test;


public class Main01 {

    /*
    测试 自己实现jdk代理AOP
     */
    @Test
    public void testJDKProxy() {
        IWorkerService workerService = WorkerServiceFactory.createWorkerService();
        String res = workerService.userInfo("fly");
        System.out.println(res);
    }

    /*
测试 自己实现CGLib
 */
    @Test
    public void testCGLibProxy() {
        WorkerServiceImpl workerService = MyBeanFactory.createWorkerServiceCGlib();
        System.out.println(workerService.getClass());
        String res = workerService.userInfo("fly");
        System.out.println(res);
    }

}
