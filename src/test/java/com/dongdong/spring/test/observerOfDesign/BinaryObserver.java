package com.dongdong.spring.test.observerOfDesign;


/**
 * @Description:
 * @Date: 2020/7/14  11:19
 * @Author: dongdong
 */
public class BinaryObserver extends  Observer {

    public BinaryObserver(Subject subject){
        this.subject=subject;
        subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println("Octal Stirng"+Integer.toOctalString(subject.getState()));
    }
}
