package com.test.multithreading;

public class YieldTest implements Runnable {

    @Override
    public void run() {
        for(int i=0;i<5;i++) {
            try {
                Thread.sleep(500);      // 休眠一下
            } catch (Exception e) { }
            System.out.println(Thread.currentThread().getName())
                    + "运行，i=" + i;      // 取得当前线程的名字
            if (i == 2) {
                System.out.print("线程礼让：");
                Thread.currentThread().yield();     // 首先获取当前线程，然后线程礼让
            }
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();     // 实例化 MyThread 对象
        Thread thread = new Thread(myThread,"线程1");
        Thread thread2 = new Thread(myThread,"线程2");
        thread.start();
        thread2.start();
    }
}
