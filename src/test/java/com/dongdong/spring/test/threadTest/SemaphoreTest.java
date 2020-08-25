package com.dongdong.spring.test.threadTest;

import java.util.concurrent.Semaphore;

/**
 * @Description:
 * @Date: 2020/8/14  13:48
 * @Author: dongdong
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(5);
        for(int i=0;i<5;i++){
            new Worker(i,semaphore).start();
        }
    }
    static class  Worker extends Thread{
        private int num;
        private Semaphore semaphore;
        public Worker(int num,Semaphore semaphore){
            this.num=num;
            this.semaphore=semaphore;
        }
        @Override
        public void run(){
            try {
                semaphore.acquire();
                Thread.sleep(1000);
                semaphore.release();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
