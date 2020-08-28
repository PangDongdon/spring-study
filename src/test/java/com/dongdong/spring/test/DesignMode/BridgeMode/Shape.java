package com.dongdong.spring.test.DesignMode.BridgeMode;

/**
 * @Description:
 * @Date: 2020/8/26  11:27
 * @Author: dongdong
 */
public  abstract  class Shape {
    protected  DrawAPI drawAPI;
    protected  Shape(DrawAPI drawAPI){
        this.drawAPI=drawAPI;
    }
    public abstract void draw();
}
