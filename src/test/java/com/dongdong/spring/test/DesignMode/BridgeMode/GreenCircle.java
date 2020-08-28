package com.dongdong.spring.test.DesignMode.BridgeMode;

/**
 * @Description:
 * @Date: 2020/8/26  11:26
 * @Author: dongdong
 */
public class GreenCircle implements  DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("画绿圆");
    }
}
