package com.dongdong.spring.test.DesignMode.decoratorModel;

/**
 * @Description:
 * @Date: 2020/8/26  13:59
 * @Author: dongdong
 */
public  abstract  class ShapeDecorator implements  Shape {
    protected  Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape=decoratedShape;
    }
    public void  draw(){
        decoratedShape.draw();
    }
}
