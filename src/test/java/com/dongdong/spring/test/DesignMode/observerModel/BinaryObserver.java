package com.dongdong.spring.test.DesignMode.observerModel;

/**
 * @Description:
 * @Date: 2020/8/27  13:45
 * @Author: dongdong
 */
public class BinaryObserver extends Observer {

    public  BinaryObserver(Subject subject){
        this.subject=subject;
        this.subject.attach(this);
    }
    @Override
    public void update() {
          System.out.println("Binary String:  "+Integer.toBinaryString(subject.getState()));
    }
}
