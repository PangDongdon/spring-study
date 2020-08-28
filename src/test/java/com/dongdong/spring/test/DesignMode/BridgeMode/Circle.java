package com.dongdong.spring.test.DesignMode.BridgeMode;

/**
 * @Description:
 * @Date: 2020/8/26  11:29
 * @Author: dongdong
 */
public class Circle extends  Shape {
    private int x,y,radius;
    protected Circle(int x,int y,int radius,DrawAPI drawAPI) {
        super(drawAPI);
        this.radius=radius;
        this.y=y;
        this.x=x;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(radius,x,y);
    }
}

