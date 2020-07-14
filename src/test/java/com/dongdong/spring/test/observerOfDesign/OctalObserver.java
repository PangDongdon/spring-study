package com.dongdong.spring.test.observerOfDesign;

/**
 * @Description:
 * @Date: 2020/7/14  11:19
 * @Author: dongdong
 */
public class OctalObserver  extends  Observer{
   public  OctalObserver(Subject subject){
       this.subject=subject;
       subject.attach(this);
   }
    @Override
    public void update() {
        System.out.println("Binary String:"+Integer.toBinaryString(subject.getState()));
    }
}
