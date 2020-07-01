package com.dongdong.spring.test.synchronizedCallback;

import lombok.Data;

import java.util.Random;

/**
 * @Description:
 * @Date: 2020/7/1  13:55
 * @Author: dongdong
 */
@Data
public class Store {
    private String name;

    public Store(String name) {
        this.name = name;
    }

 /**
  * 回调函数，将结构传给那个不能直接调用的方法，然后获取结果
  */
 public String returnOrderGoodsInfo(OrderResult order){
     String[] s={"订购中","订购失败","即将发货","运输中....."};
     Random random=new Random();
     int temp=random.nextInt(4);
     String s1=s[temp];
     return order.getOrderResult(s1);
 }
}
