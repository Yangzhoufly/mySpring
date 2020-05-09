package com.fly.proxy.jdk.service;

public class WorkerServiceImpl implements IWorkerService {
    @Override
    public void addWorker() {
        System.out.println("WorkerServiceImpl 添加worker");
    }

    @Override
    public void updateWorker() {
        System.out.println("WorkerServiceImpl 更新worker");

    }

    @Override
    public void deleteWorker() {
        System.out.println("WorkerServiceImpl 删除worker");
        int a = 1/0;
    }

    @Override
    public String userInfo(String name) {
        System.out.println("runing");
        return "hello "+name;
    }
}
