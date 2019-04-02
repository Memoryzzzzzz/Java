package com.test.multithreading;

public class Test {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();     // 定义线程对象
        Thread thread = new Thread(myThread);   // 定义Thread对象
        Thread thread2 = new Thread(myThread);  // 定义Thread对象
        Thread thread3 = new Thread(myThread);  // 定义Thread对象
        thread.setName("线程1");
        thread2.setName("线程2");
        thread3.setName("线程3");
        thread.start();
        thread2.start();
        thread3.start();
    }
}

class MyThread implements Runnable {
    private int ticket = 5;
    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 2; i++) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "买到票，剩余票数：" + --ticket);
                } else {
                    System.out.println(Thread.currentThread().getName() + "没买到票");
                }
            }
        }
    }
}