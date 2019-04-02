package com.test.multithreading;

import java.util.concurrent.*;

public class ThreadPollExecutor {


    public static void main(String[] args) {

        RejectedExecutionHandler rejectedHandler = new RejectedExecutionHandlerImpl();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,3,200,
                TimeUnit.MICROSECONDS,new ArrayBlockingQueue<Runnable>(6),rejectedHandler);

        for(int i=0;i<9;i++){
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目："+executor.getPoolSize()
                    +"，队列中等待执行的任务数目："+executor.getQueue().size());
        }
        executor.shutdown();
    }


    static class MyTask implements Runnable{
        private int taskNum;

        public MyTask(int num){
            this.taskNum = num;
        }

        @Override
        public void run(){
            System.out.println("正在执行task "+taskNum);
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("task "+taskNum+"执行完毕！");
        }
    }
}
