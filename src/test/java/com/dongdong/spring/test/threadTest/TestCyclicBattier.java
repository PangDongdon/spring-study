package com.dongdong.spring.test.threadTest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description:
 * @Date: 2020/8/14  13:28
 * @Author: dongdong
 */
public class TestCyclicBattier {
    private CyclicBarrier cyclicBarrier=new CyclicBarrier(6);

    public static void main(String[] args) {
        new TestCyclicBattier().begin();
    }



    public void  begin(){
        for(int i=0;i<5;i++){
            new Thread(new Student()).start();
        }
    }
    private class  Student implements  Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+"正在执行");
                cyclicBarrier.await();
                Thread.sleep(3000);
                System.out.println("********");
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
