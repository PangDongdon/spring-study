package com.dongdong.spring.test.testPackage;

import org.apache.logging.log4j.ThreadContext;

/**
 * @Description:
 * @Date: 2019/12/2  9:42
 * @Author: dongdong
 */
public class testVolatile {
    private static  volatile   String userName;

    private static class UserThread implements  Runnable   {
        @Override
        public void run() {
         System.out.println(Thread.currentThread().getName()+"线程正在运行");
         userName="dd";
        }
    }


    public static  void main(String[] args) throws InterruptedException {
        userName="dongdong";
        Thread  t=new Thread(new UserThread());
        t.start();
        System.out.println(Thread.currentThread().getName()+"线程正在运行");
        t.join();
        System.out.println(userName);




    }
}
