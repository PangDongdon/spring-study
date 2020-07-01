package com.dongdong.spring.test.synchronizedCallback;

import lombok.Data;

import java.util.Random;

/**
 * @Description: 同步顾客类,同步顾客在商店预定商品，商店通知顾客预定情况
 * @Date: 2020/7/1  14:06
 * @Author: dongdong
 */
@Data
public class SyncBuyer  implements OrderResult{

    private  Store store; //商店

    private String buyerName;// 购物者名

    private String goodsName;// 所购商品名


    public SyncBuyer(Store store, String buyerName, String goodsName) {
        this.store = store;
        this.buyerName = buyerName;
        this.goodsName = goodsName;
    }
    //调用从商店返回订购物品信息
    public String orderGoods(){
        String goodsState = store.returnOrderGoodsInfo(this);
        System.out.println(goodsState);
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

}
