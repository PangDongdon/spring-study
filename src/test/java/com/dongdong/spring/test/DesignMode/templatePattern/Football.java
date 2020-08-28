package com.dongdong.spring.test.DesignMode.templatePattern;

/**
 * @Description:
 * @Date: 2020/8/28  9:46
 * @Author: dongdong
 */
public class Football extends  Game {
    @Override
    void initialize() {
        System.out.println("football is initialize");
    }

    @Override
    void startPlay() {
        System.out.println("football is start");
    }

    @Override
    void endPlay() {
        System.out.println("football is end");
    }
}
