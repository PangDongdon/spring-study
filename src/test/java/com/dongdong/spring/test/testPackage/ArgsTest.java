package com.dongdong.spring.test.testPackage;

/**
 * @Description:
 * @Date: 2020/5/7  15:49
 * @Author: dongdong
 */
public class ArgsTest {
    public static void main(String[] args) {
        System.out.println(args.length);
        for (String s: args) {
            System.out.println(s);
        }
    }
}
