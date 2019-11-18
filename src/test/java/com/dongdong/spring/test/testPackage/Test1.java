package com.dongdong.spring.test.testPackage;

/**
 * @Description:
 * @Date: 2019/11/12  19:07
 * @Author: dongdong
 */
public class Test1 extends Person {
    public int a=0;
    static Integer si=6;
    String s="Hello World";
    public Test1( int a){

    }

    @Override
    public void say1() {
       System.out.println("t");
    }

    @Override
    public void do1() {
       a++;
       System.out.println(a);
    }
}
