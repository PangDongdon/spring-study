package com.dongdong.spring.test.Locktest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Date: 2019/10/25  12:57
 * @Author: dongdong
 */
public class LockTest {
    public  int inc=0;
    Lock lock=new ReentrantLock();
    public  void  increase(){
        try {
            lock.lock();
            inc++;
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[]args){
        final LockTest  lockTest=new LockTest();
        for(int i=0;i<3;i++){
            new Thread(){
                public void run(){
                    for(int j=0;j<100;j++){
                        lockTest.increase();
                        System.out.println(Thread.currentThread().getName()+": "+j);
                    }
                }
            }.start();
        }
        while(Thread.activeCount()>1){
            Thread.yield();
        }
        System.out.println(lockTest.inc);
        Integer.valueOf(2);
        Double.valueOf(3.4);
    }

}
