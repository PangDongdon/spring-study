package com.dongdong.spring.test.DesignMode.templatePattern;

/**
 * @Description:
 * @Date: 2020/8/28  10:16
 * @Author: dongdong
 */
public class TemplatePatternDemo {

    public static void main(String[] args) {
        Game game=new Cricket();
        game.play();
        game=new Football();
        game.play();
    }
}
