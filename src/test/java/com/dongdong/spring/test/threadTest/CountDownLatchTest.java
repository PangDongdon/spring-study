package com.dongdong.spring.test.threadTest;

import org.checkerframework.checker.units.qual.C;

import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 * @Date: 2020/7/31  17:53
 * @Author: dongdong
 */
public class CountDownLatchTest {
  static final CountDownLatch latch=new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException {
        //1.
       new Thread(){
        public void run(){
            System.out.println(Thread.currentThread().getName()+"正在执行");
            latch.countDown();
        }}.start();

        new Thread(){
            public void run(){
                System.out.println(Thread.currentThread().getName()+"正在执行");
                latch.countDown();
            }}.start();
        System.out.println(Thread.currentThread().getName()+"running");
        latch.await();
        System.out.println("2个子线程已经执行完");
        System.out.println("主线程继续执行");
    }
}
