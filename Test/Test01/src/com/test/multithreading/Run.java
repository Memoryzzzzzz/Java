package com.test.multithreading;

public class Run implements Runnable {

    @Override
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+"运行 -->"+i);
        }
    }

    public static void main(String[] args) {
        Run run = new Run();                            // 实例化 Runnable 子类对象
        Thread thread = new Thread(run, "线程");  // 实例化 Thread 对象
        thread.start();                                 // 启动线程
        for(int i=0;i<5;i++){
            if(i>2){
                try{
                    thread.join();                      // 线程强制运行
                }catch(InterruptedException e){}
            }
            System.out.println("Main线程运行 -->"+i);
        }
    }
}
