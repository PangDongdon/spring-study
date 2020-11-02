package com.dongdong.spring.test.threadTest;

import net.dongliu.commons.Sys;

import java.awt.*;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.FutureTask;

public class CallableTest implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(33);
        return 22;
    }

    public static void main(String[] args) {
        CallableTest callableTest=   new CallableTest();
        FutureTask<Integer> futureTask=new FutureTask<>(callableTest);
        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());
        }catch(Exception e){
            e.fillInStackTrace();
        }
    }
}
