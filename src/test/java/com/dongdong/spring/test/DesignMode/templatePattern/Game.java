package com.dongdong.spring.test.DesignMode.templatePattern;

/**
 * @Description:
 * @Date: 2020/8/28  9:40
 * @Author: dongdong
 */
public  abstract  class Game {
    abstract  void initialize();
    abstract  void startPlay();
    abstract  void endPlay();

    public final void play(){
        initialize();
        startPlay();
        endPlay();
    }
}
