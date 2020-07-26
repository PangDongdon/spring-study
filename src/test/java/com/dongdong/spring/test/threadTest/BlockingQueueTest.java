package com.dongdong.spring.test.threadTest;

import ch.qos.logback.core.db.dialect.SybaseSqlAnywhereDialect;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ForkJoinPool;

public class BlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue=new ArrayBlockingQueue(2);
        blockingQueue.put("dd");
        blockingQueue.put("d");
        //blockingQueue.put("pdd");
        System.out.println(blockingQueue);
        //ForkJoinPool
    }
}
