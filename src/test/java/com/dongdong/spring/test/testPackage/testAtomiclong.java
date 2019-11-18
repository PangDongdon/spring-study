package com.dongdong.spring.test.testPackage;

import org.junit.experimental.theories.Theories;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description:
 * @Date: 2019/11/18  10:57
 * @Author: dongdong
 */
public class testAtomiclong implements    Runnable {
  private  int i=1;
  private AtomicLong value= new AtomicLong(2l);
  Object obj=new Object();
  public  static void main(String[] args){
      testAtomiclong test=  new testAtomiclong();
      Thread t=new Thread(test);
      Thread t1=new Thread(test);
      t1.start();
      t.start();
    }


    public synchronized    void run() {

            while (value.get() <= 20) {
                /*  synchronized(this) {*/
                //  value.incrementAndGet();
                try {
                    notify();
                } catch (Exception e) {
                    e.getStackTrace();
                }
                // i++;
                value.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + "的值是：" + value);
                try {
                    wait();
                } catch (Exception e) {
                    e.getStackTrace();
                }
                if (value.get() == 21) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.getStackTrace();
                    }
                }
                /* }*/
        }
    }
}
