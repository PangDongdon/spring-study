package com.dongdong.spring.test.DesignMode.decoratorModel;

/**
 * @Description:
 * @Date: 2020/8/26  15:53
 * @Author: dongdong
 */
public class DecoratorTest {
    public static void main(String[] args) {
        Shape shape=new Circle();
        ShapeDecorator shapeDecorator=new RedShapeDecorator(shape);
        shapeDecorator.draw();
    }
}
