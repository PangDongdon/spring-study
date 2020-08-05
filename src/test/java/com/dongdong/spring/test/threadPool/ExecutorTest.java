package com.dongdong.spring.test.threadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: test
 * @Date: 2020/7/30  11:41
 * @Author: dongdong
 */
public class ExecutorTest {

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(6);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
               System.out.println(Thread.currentThread().getName()+":已经执行");
            }
        });
        executorService.shutdownNow();
    }
}
