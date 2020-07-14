package com.dongdong.spring.test.observerOfDesign;

/**
 * @Description:
 * @Date: 2020/7/14  11:19
 * @Author: dongdong
 */
public class HexaObserver extends  Observer {
     public HexaObserver(Subject subject){
         this.subject=subject;
         subject.attach(this);
     }
    @Override
    public void update() {
        System.out.println("Hex String:"+Integer.toHexString(subject.getState()).toUpperCase());
    }
}
