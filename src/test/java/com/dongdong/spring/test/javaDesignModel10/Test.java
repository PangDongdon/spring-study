package com.dongdong.spring.test.javaDesignModel10;

/**
 * 外观模式
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/30  10:52
 */
public class Test {
    public static void main(String[] args){
        IServiceA a=new ServiceImplA();
        IServiceB b=new ServiceImplB();
        a.methodA();
        b.methodB();
        System.out.println("======================");
        Faced f=new Faced();
        f.methodA();
        f.methodB();
    }
}
