package com.dongdong.spring.test.threadTest;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;

/**
 * @Description:  模拟并发
 * @Date: 2020/8/14  11:30
 * @Author: dongdong
 */
public class CountDownLatchTest2 {
    CountDownLatch countDownLatch=new CountDownLatch(1);

    @Test
    public  void main11() throws InterruptedException {

        for(int i=0;i<100;i++){
            new Thread(new Task(countDownLatch)).start();
        }
        countDownLatch.countDown();
        countDownLatch.await();
        System.out.println("主线程开始执行了");

    }

  private   class Task implements  Runnable{
         final  CountDownLatch startLatch;

      private Task(CountDownLatch startLatch) {
          this.startLatch = startLatch;
      }

      @Override
        public void run() {
            try {
                countDownLatch.await();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"开始执行"+"，执行时间为："+ System.currentTimeMillis());
        }
    }

}
