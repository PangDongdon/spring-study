package com.dongdong.spring.test2.thread;


import org.junit.Test;

/**
 * @Description:
 * @Date: 2021/2/5  14:43
 * @Author: dongdong
 */
public class MyselfBlockQueueTest {
    //定义两把锁
    private static  Object lockOne=new Object();
    private static  Object lockTwo=new Object();

    private  void  test1() throws InterruptedException {
        String threadName=Thread.currentThread().getName();
        synchronized (lockTwo){
                System.out.println(threadName+"拿到了第一把锁");
            Thread.sleep(100);
            synchronized (lockOne){
                System.out.println(threadName+"拿到了第二把锁");
            }
        }
    }


    private  void  test2() throws InterruptedException {
        String threadName=Thread.currentThread().getName();
        synchronized (lockTwo){
            System.out.println(threadName+"拿到了第二把锁");
            Thread.sleep(100);
            synchronized (lockOne){
                System.out.println(threadName+"拿到了第一把锁");
            }
        }
    }

    private  class  Task implements Runnable {


        @Override
        public void run() {
            try {
                test1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void  deadLockTest() throws InterruptedException {
        Thread thread=new Thread(new Task());
        thread.start();
        test2();
    }


}
