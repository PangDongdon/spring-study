package com.dongdong.spring.test.DesignMode.factoryPattern;

/**
 * @Description:
 * @Date: 2020/8/25  15:07
 * @Author: dongdong
 */
public class Square implements  Shape {
    @Override
    public void draw() {
        System.out.println("square init...");
    }
}
