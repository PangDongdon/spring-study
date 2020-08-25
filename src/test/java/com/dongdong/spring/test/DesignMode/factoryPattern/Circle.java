package com.dongdong.spring.test.DesignMode.factoryPattern;

/**
 * @Description:
 * @Date: 2020/8/25  15:06
 * @Author: dongdong
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle init...");
    }
}
