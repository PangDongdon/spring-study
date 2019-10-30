package com.dongdong.spring.test.Locktest;

/**
 * @Description:
 * @Date: 2019/10/25  11:54
 * @Author: dongdong
 */
public class VolatileTest {
    public  int inc=0;

    public synchronized void  increase(){
        inc++;
    }
    public static void main(String[]args){
        final VolatileTest  volatileTest=new VolatileTest();
        for(int i=0;i<3;i++){
            new Thread(){
                public void run(){
                    for(int j=0;j<100;j++){
                        volatileTest.increase();
                        System.out.println(Thread.currentThread().getName()+": "+j);
                    }
                }
            }.start();
        }
        while(Thread.activeCount()>1){
            Thread.yield();
        }
        System.out.println(volatileTest.inc);
    }

}
