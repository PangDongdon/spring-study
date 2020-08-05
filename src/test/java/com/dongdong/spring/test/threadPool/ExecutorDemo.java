package com.dongdong.spring.test.threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description:  自定义线程池 1： 线程池核心数 2：线程池的最大数 3：存活时间 4: 阻塞队列 5;淘汰策略
 * @Date: 2020/7/1  10:44
 * @Author: dongdong
 */
public class ExecutorDemo {
    //核心线程数
    private static final int corePoolSize=2;
    //最大线程数
    private static  final  int maxmumPoolSize=5;
    //线程空闲下来，存活时间
    private static final long  keepAliveTime=0L;
    //自定义线程池
    public static ThreadPoolExecutor poolExecutor=new ThreadPoolExecutor(corePoolSize,maxmumPoolSize,keepAliveTime, TimeUnit.MICROSECONDS,new ArrayBlockingQueue<Runnable>(3),new MyRejectedExcutionHandler());


    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            poolExecutor.execute(new Worker("task"+i));
        }
        //归还线程池
        poolExecutor.shutdown();
    }
}
