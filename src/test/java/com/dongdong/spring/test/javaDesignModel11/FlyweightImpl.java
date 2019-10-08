package com.dongdong.spring.test.javaDesignModel11;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/30  11:09
 */
public class FlyweightImpl implements  Flyweight {
    @Override
    public void action(int args) {
        System.out.println("参数args"+args);
    }
}
