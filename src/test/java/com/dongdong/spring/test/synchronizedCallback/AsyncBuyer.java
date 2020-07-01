package com.dongdong.spring.test.synchronizedCallback;

import lombok.Data;
import net.dongliu.commons.Sys;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description: 同步顾客类,同步顾客在商店预定商品，商店通知顾客预定情况
 * @Date: 2020/7/1  14:06
 * @Author: dongdong
 */
@Data
public class AsyncBuyer implements OrderResult{

    private  Store store; //商店

    private String buyerName;// 购物者名

    private String goodsName;// 所购商品名


    public AsyncBuyer(Store store, String buyerName, String goodsName) {
        this.store = store;
        this.buyerName = buyerName;
        this.goodsName = goodsName;
    }
    //调用从商店返回订购物品信息
    public String orderGoods() throws ExecutionException, InterruptedException {
        String goodsState="--";
        MyRunnable myRunnable=new MyRunnable();
        FutureTask<String> futureTask=new FutureTask<>(myRunnable);
        Thread thread=new Thread(futureTask);
        thread.start();
//      String goodsState = store.returnOrderGoodsInfo(this);
        System.out.println("前"+goodsState);
        goodsState=futureTask.get();
        System.out.println("后"+goodsState);
        myFeeling();
        return  goodsState;
    }

    @Override
    public String getOrderResult(String state) {
        return "在"+this.getStore().getName()+"商店订购"+this.getGoodsName()+"玩具目前的状态："+state;
    }

    public void myFeeling(){
       String[] s={"有点小激动","很期待","希望能是个好货"};
        Random random=new Random();
        int temp=random.nextInt(3);
        System.out.println("我是"+this.getGoodsName()+",我现在的感觉是"+s[temp]);

    }

    @Data
    private class MyRunnable implements Callable {
        private String result;

        @Override
        public Object call() throws Exception {
            try {
                Thread.sleep(10000);
                result=store.returnOrderGoodsInfo(AsyncBuyer.this);
                System.out.println("result=======我是异步被调用");
                return  result;
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("出大事，异步回调有问题了"+e.getMessage());
                return e.getMessage();
            }
        }
    }

}
