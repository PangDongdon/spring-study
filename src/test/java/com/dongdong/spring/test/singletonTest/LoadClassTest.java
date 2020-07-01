package com.dongdong.spring.test.singletonTest;
/**
 * @Description:
 * @Date: 2020/6/17  10:49
 * @Author: dongdong
 */
public class LoadClassTest {

    public static void main(String[] args) {
        ClassLoader c=LoadClassTest.class.getClassLoader();
        System.out.println(c);
        ClassLoader c1=c.getParent();
        System.out.println(c1);
        ClassLoader c2=c1.getParent();
        System.out.println(c2);
    }
}
