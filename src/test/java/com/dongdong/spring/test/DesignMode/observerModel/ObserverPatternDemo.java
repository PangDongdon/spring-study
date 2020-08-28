package com.dongdong.spring.test.DesignMode.observerModel;

/**
 * @Description:
 * @Date: 2020/8/27  13:52
 * @Author: dongdong
 */
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject=new Subject();
        new  BinaryObserver(subject);
        subject.setState(15);
    }
}
