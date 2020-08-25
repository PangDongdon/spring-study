package com.dongdong.spring.test.DesignMode.abstractFactoryPattern;

/**
 * @Description:
 * @Date: 2020/8/25  16:26
 * @Author: dongdong
 */
public abstract  class AbstractFactor {
    public abstract Color getColor(String color);
    public abstract  Shape getShape(String shape);
}
