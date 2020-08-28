package com.dongdong.spring.test.DesignMode.decoratorModel;

/**
 * @Description:
 * @Date: 2020/8/26  13:58
 * @Author: dongdong
 */
public class Circle implements Shape {
    @Override
    public void draw() {
     System.out.println("Circle of draw");
    }
}
