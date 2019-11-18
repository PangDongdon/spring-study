package com.dongdong.spring.test.testPackage;

/**
 * @Description:
 * @Date: 2019/11/18  13:59
 * @Author: dongdong
 */
public class threadTest extends Thread {
    private int i=1;
    Object object=new Object();
    public static void main(String[] args){
        threadTest t=new threadTest();
        threadTest t1=new threadTest();
        t.start();
        t1.start();
    }
    @Override
    public  void run(){
        synchronized (object) {
            while (i<= 20) {
                i++;
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
