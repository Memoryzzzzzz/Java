package com.test.multithreading;

public class DeadLockTest {
    public static void main(String[] args) {

        Thread thread = new Thread(new DeadLock(true),"线程1");
        Thread thread2 = new Thread(new DeadLock(true),"线程2");

        thread.start();
        thread2.start();
    }
}

class DeadLock implements Runnable{

    private static Object object = new Object();
    private static Object object2 = new Object();
    private boolean flag;

    public DeadLock(boolean flag){
        this.flag = flag;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"运行");
        if(flag){
            synchronized(object){
                System.out.println(Thread.currentThread().getName()+"已经锁住object");
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                synchronized(object2){
                    System.out.println("1秒后："+Thread.currentThread().getName()+"锁住object2");
                }
            }
        }else{
            synchronized(object2){
                System.out.println(Thread.currentThread().getName()+"已经锁住object2");
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                synchronized(object){
                    System.out.println("1秒后："+Thread.currentThread().getName()+"锁住object");
                }
            }
        }
    }
}