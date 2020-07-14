package com.dongdong.spring.test.observerOfDesign;


/**
 * @Description:
 * @Date: 2020/7/14  11:19
 * @Author: dongdong
 */
public class BinaryObserver extends  Observer {

    @Override
    public void update() {
        System.out.println("Octal");
    }
}
