package com.dongdong.spring.test.observerOfDesign;

/**
 * @Description:
 * @Date: 2020/7/14  11:07
 * @Author: dongdong
 */
public  abstract  class Observer {
    protected  Subject subject;
    public abstract  void update();
}
