package com.dongdong.spring.test.DesignMode.observerModel;

/**
 * @Description:
 * @Date: 2020/8/27  13:42
 * @Author: dongdong
 */
public abstract class Observer {
    protected  Subject subject;
    public abstract void update();
}
