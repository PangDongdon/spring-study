package com.dongdong.spring.test.jvm.jvmLoad;

/**
 * @Description:
 * @Date: 2020/11/4  14:09
 * @Author: dongdong
 */
public class ConstClass {

    static {
        System.out.println("Constclass init");
    }
    public static  final  String HELLOEORD="hello world";
}
