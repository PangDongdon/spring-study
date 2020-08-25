package com.dongdong.spring.test.DesignMode.factoryPattern;

/**
 * @Description:
 * @Date: 2020/8/25  15:23
 * @Author: dongdong
 */
public class ShapeTest {

    public static void main(String[] args) {
        Shape shape=ShapeFactory.getShape("Circle");
        shape.draw();
        Shape shape1=ShapeFactory.getShape("Square");
        shape1.draw();
    }
}
