package com.dongdong.spring.test.synchronizedCallback;

import java.util.concurrent.ExecutionException;

/**
 * @Description:
 * @Date: 2020/7/1  16:25
 * @Author: dongdong
 */
public class Test2Callback {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Store wallMark=new Store("啥中路沃尔玛");
        SyncBuyer syncBuyer=new SyncBuyer(wallMark,"小明","超能铁扇公主");
        System.out.println(syncBuyer.orderGoods());
        System.out.println("==============**异步执行结果为**==========================");
        Store wallMark1=new Store("苏果");
        AsyncBuyer asyncBuyer=new AsyncBuyer(wallMark1,"小红","超人");
        System.out.println(asyncBuyer.orderGoods());
    }
}
