package com.test.multithreading;

public class YieldTest implements Runnable {

    @Override
    public void run() {
        for (int i=0; i<10; i++) {
            try {
                //Thread.sleep(500);
            } catch (Exception e) {}
            System.out.println(Thread.currentThread().getName() + "运行，i = " + i);

            if (i ==2) {
                System.out.println(Thread.currentThread().getName() + "礼让");
                Thread.yield();
            }
        }
    }

    public static void main(String args[]) {
        YieldTest yieldTest = new YieldTest();
        Thread t1 = new Thread(yieldTest, "线程A");
        //Thread t2 = new Thread(yieldTest, "线程B");
        t1.start();
        //t2.start();

        for (int i=0; i<10; i++) {
            try {
                //Thread.sleep(500);
            } catch (Exception e) {}
            System.out.println("主线程运行，i = " + i);

            if (i ==5) {
                System.out.println("主线程运行礼让");
                Thread.yield();
            }
        }
    }
}
