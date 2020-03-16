package com.dongdong.spring.test.testPackage;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Description:
 * @Date: 2019/12/10  11:50
 * @Author: dongdong
 */
public class HashMapTest {

    public  static void main(String[] args){
        HashMapThread t1=new HashMapThread();
        HashMapThread t2=new HashMapThread();
        HashMapThread t3=new HashMapThread();
        HashMapThread t4=new HashMapThread();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}


class HashMapThread extends  Thread{
    private static AtomicInteger ai=new AtomicInteger();
    private static Map<Integer,Integer> map=new HashMap<>();
    @Override
    public void run(){
        while (ai.get()<100000){
            map.put(ai.get(),ai.get());
            ai.incrementAndGet();
        }
        System.out.println(ai.get());
    }






}
