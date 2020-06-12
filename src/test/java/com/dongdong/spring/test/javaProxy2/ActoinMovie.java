package com.dongdong.spring.test.javaProxy2;

/**
 * @Description:
 * @Date: 2020/6/1  10:37
 * @Author: dongdong
 */
public class ActoinMovie implements Movie {
    @Override
    public void watchMovie() {
        System.out.println("看武打电影");
    }
}
