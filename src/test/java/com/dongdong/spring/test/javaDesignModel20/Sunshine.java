package com.dongdong.spring.test.javaDesignModel20;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/10/8  12:58
 */
public class Sunshine implements  Weather {
    @Override
    public String getWeather() {
        return "阳光明媚";
    }
}
