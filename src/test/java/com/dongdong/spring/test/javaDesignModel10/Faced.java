package com.dongdong.spring.test.javaDesignModel10;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/30  10:47
 */
public class Faced {

    IServiceA serviceA;
    IServiceC serviceC;
    IServiceB serviceB;

    public Faced() {
        this.serviceA = new ServiceImplA();
        this.serviceC =  new ServiceImplC();
        this.serviceB =  new ServiceImplB();
    }

    public void methodA(){
        serviceA.methodA();
        serviceB.methodB();
    }

    public void methodB(){
        serviceC.methodC();
        serviceB.methodB();
    }

    public void methodC(){
        serviceA.methodA();
        serviceC.methodC();
    }

}
