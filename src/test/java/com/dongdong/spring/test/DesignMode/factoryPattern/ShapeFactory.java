package com.dongdong.spring.test.DesignMode.factoryPattern;

/**
 * @Description: 形状工厂
 * @Date: 2020/8/25  15:04
 * @Author: dongdong
 */
public class ShapeFactory {

    public static Shape getShape(String shapeType){
        if("Circle".equals(shapeType)){
            return new Circle();
        }else if("Square".equals(shapeType)){
            return new Square();
        }else {
            return  null;
        }
    }
}
