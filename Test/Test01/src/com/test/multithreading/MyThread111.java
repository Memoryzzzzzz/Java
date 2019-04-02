package com.test.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyThread111 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int i=0;
        for(;i<5;i++){
            System.out.println(Thread.currentThread().getName()+"："+i);
        }

        // cal()方法有返回值
        return i;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<Integer> callable = new MyThread111();
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask, "线程1");

        FutureTask<Integer> futureTask2 = new FutureTask<>(callable);
        Thread thread2 = new Thread(futureTask, "线程2");

        thread.start();
        thread2.start();
    }
}
