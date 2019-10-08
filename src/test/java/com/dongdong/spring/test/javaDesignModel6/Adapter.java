package com.dongdong.spring.test.javaDesignModel6;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/29  14:47
 */
public class Adapter implements  Target {
    private Adaptee adaptee;

    public  Adapter(Adaptee adaptee){
        this.adaptee=adaptee;
    }

    @Override
    public void adapteeMethod() {
        adaptee.adapteeMethod();
    }

    @Override
    public void adapterMethod() {
     System.out.println("this is adapterMethod");
    }
}
