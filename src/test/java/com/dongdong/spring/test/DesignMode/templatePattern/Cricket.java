package com.dongdong.spring.test.DesignMode.templatePattern;

/**
 * @Description:
 * @Date: 2020/8/28  9:45
 * @Author: dongdong
 */
public class Cricket extends  Game {
    @Override
    void initialize() {
    System.out.println("Cricket is initialize");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket is Start");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket is end");
    }
}
