package com.dongdong.spring.test.threadTest;


import org.junit.Test;

/**
 * @Description:
 * @Date: 2020/8/13  11:23
 * @Author: dongdong
 */
public class DeadLock {
    private static String  object1="object1";
    private static String  object2="object2";

    @Test
    public  void test() {
        System.out.println("当前线程名称"+Thread.currentThread().getName());
      Thread a=  new Thread(new Object1());
      Thread b=  new Thread(new Object2());
      a.start();
      b.start();
      try {
          a.join();
          b.join();
      }catch(Exception e){
          e.printStackTrace();
      }
    }

       class Object1 implements  Runnable{
        @Override
        public void run() {
            try {
                while (true) {
                    synchronized (DeadLock.object1) {
                        System.out.println("lock--" + object1);
                        Thread.sleep(5000);
                        synchronized (DeadLock.object2) {
                            System.out.println("lock--" + object2);
                        }
                    }
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    class Object2 implements  Runnable{
        @Override
        public void run() {
            try {
                while (true) {
                    synchronized (DeadLock.object2) {
                        System.out.println("lock" + object2);
                        Thread.sleep(2000);
                        synchronized (DeadLock.object1) {
                            System.out.println("lock" + object1);
                        }
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
