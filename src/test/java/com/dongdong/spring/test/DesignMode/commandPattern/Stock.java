package com.dongdong.spring.test.DesignMode.commandPattern;

import net.dongliu.commons.Sys;
import org.springframework.security.core.parameters.P;

/**
 * @Description: entity of  stock
 * @Date: 2020/8/27  9:36
 * @Author: dongdong
 */
public class Stock {
    private String name="ABC";
    private int quantity=10;

    public void buy(){
        System.out.println("Stock"+name+"Quantity"+quantity+"bought");
    }

    public void  sell(){
        System.out.println("Stock"+name+"Quantity"+quantity+"sold");
    }

}
