package com.dongdong.spring.test.DesignMode.decoratorModel;

/**
 * @Description:
 * @Date: 2020/8/26  15:49
 * @Author: dongdong
 */
public class RedShapeDecorator extends  ShapeDecorator {

    public  RedShapeDecorator(Shape decoratedShape){
        super(decoratedShape);
    }
    @Override
    public void draw(){
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }
    private void setRedBorder(Shape decorated){
        System.out.println("Border Color:red");
    }

}
