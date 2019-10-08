package com.dongdong.spring.test.javaDesignModel20;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/10/8  12:58
 */
public class Rain implements  Weather {
    @Override
    public String getWeather() {
        return "下雨天";
    }
}
