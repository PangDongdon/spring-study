package com.dongdong.spring.test.testPackage;

/**
 * @Description:
 * @Date: 2019/11/18  15:24
 * @Author: dongdong
 */
public class testDisPatch {

    static abstract class Human {
    }

    static class Man extends Human {

    }

    static class Woman extends Human {

    }


    public void sayHello(Human guy) {
        System.out.println("hello guy");
    }


    public void sayHello(Man guy) {
        System.out.println("hello gettleman");
    }

    public void sayHello(Woman guy) {
        System.out.println("hello laid");
    }

    public static void main(String[] args) {
        //Human 称为变量静态类型   编译期可知 ,运行期不可变
        //Woman 称为变量的实际类型 编译器不可知，运行期才可确定
        Human man = new Man();
        Human woman = new Woman();
        testDisPatch testDisPatch = new testDisPatch();
        testDisPatch.sayHello(man);
        testDisPatch.sayHello(woman);
    }
}
