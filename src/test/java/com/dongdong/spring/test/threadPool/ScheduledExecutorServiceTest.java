package com.dongdong.spring.test.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Date: 2020/7/30  13:28
 * @Author: dongdong
 */
public class ScheduledExecutorServiceTest {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(3);
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
             System.out.println("delay 3 s");
            }
        },3, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟1s后 3s执行一次");
            }
        },1,3,TimeUnit.SECONDS);
    }
}
