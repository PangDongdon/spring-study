package com.dongdong.spring.test.Locktest;

/**
 * @Description:
 * @Date: 2019/10/25  16:46
 * @Author: dongdong
 */
public class vvvv {
    public  void authorized(boolean exp) {
        if (!exp) {
            throw new RuntimeException("类型不正确");
        }
    }
}
