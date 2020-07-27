package com.dongdong.spring.test.observerOfDesign;

/**
 * @Description:
 * @Date: 2020/7/14  18:19
 * @Author: dongdong
 */
public class ObserverPatternDemo {

    public static void main(String[] args) {
         Subject subject=new Subject();
         new HexaObserver(subject);
         new OctalObserver(subject);
         new BinaryObserver(subject);

        System.out.println("First state change :15");
        subject.setState(15);
        System.out.println("second state change :10");
        subject.setState(10);
    }
}
