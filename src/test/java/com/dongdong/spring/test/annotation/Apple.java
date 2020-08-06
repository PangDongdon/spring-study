package com.dongdong.spring.test.annotation;

/**
 * @Description:
 * @Date: 2020/8/5  15:08
 * @Author: dongdong
 */
public class Apple {
    @FruitProvider(id = 1,name = "红富士",address = "安徽")
    private  String appleProvider;

    public String getAppleProvider() {
        return appleProvider;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }
}
