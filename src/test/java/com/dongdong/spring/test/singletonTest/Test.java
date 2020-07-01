package com.dongdong.spring.test.singletonTest;

/**
 * @Description:
 * @Date: 2020/6/17  10:16
 * @Author: dongdong
 */
public enum Test {
    INSTANCE;
     Test(){

     }

    public static void main(String[] args) {
        Test ss=Test.INSTANCE;
    }



}
