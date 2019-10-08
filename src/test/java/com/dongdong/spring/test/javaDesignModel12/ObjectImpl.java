package com.dongdong.spring.test.javaDesignModel12;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/30  13:48
 */
public class ObjectImpl implements  Object{




    @Override
    public void action() {
        System.out.println("===========");
        System.out.println("这是被代理的类");
        System.out.println("===========");
    }
}
