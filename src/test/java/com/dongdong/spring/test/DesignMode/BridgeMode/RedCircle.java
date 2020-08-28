package com.dongdong.spring.test.DesignMode.BridgeMode;

/**
 * @Description:
 * @Date: 2020/8/26  11:25
 * @Author: dongdong
 */
public class RedCircle implements  DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("画红圆");
    }
}
