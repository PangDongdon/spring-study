package com.dongdong.spring.test.DesignMode.commandPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Date: 2020/8/27  9:46
 * @Author: dongdong
 */
public class Broker {

    private List<Order>  orderList  =new ArrayList<>();

    public void takeOrder(Order order){
        orderList.add(order);
    }

    public void placeOrders(){
        for(Order order:orderList){
            order.execute();
        }
        orderList.clear();
    }
}
