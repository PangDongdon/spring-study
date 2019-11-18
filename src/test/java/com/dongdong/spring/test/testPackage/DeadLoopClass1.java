package com.dongdong.spring.test.testPackage;

/**
 * @Description:
 * @Date: 2019/11/15  14:00
 * @Author: dongdong
 */
public class DeadLoopClass1 {

    public static void main(String[] args){

        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread()+"start");
                DeadLoopClass deadLoopClass=new DeadLoopClass();
                System.out.println(Thread.currentThread()+"over");
            }
        };
        Thread thread=new Thread(runnable);
        System.out.println(thread.getName());
        Thread thread1=new Thread(runnable);
        System.out.println(thread1.getName());
        thread.start();
        thread1.start();
    }
}
