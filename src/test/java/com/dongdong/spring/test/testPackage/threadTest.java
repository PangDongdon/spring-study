package com.dongdong.spring.test.testPackage;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Date: 2019/11/18  13:59
 * @Author: dongdong
 */
public class threadTest implements Runnable {

    private int i=1;
    Object object=new Object();
    public static void main(String[] args){
        /*threadTest t=new threadTest();
        threadTest t1=new threadTest();*/
        threadTest dd=new threadTest();
        Thread t=new Thread(dd);
        Thread t1=new Thread(dd);
        t.start();
        t1.start();
    }
    @Override
    public  void run(){
        Lock lock=null;
       try {
          lock=new ReentrantLock();
           lock.lock();
           while (i <= 20) {
               System.out.println(Thread.currentThread().getName() + ":" + (++i));
           }
       }catch(Exception e){
           e.printStackTrace();
        }finally {
           lock.unlock();
       }
    }
}
