package com.dongdong.spring.test.testPackage;

/**
 * @Description:
 * @Date: 2019/11/13  17:04
 * @Author: dongdong
 */
public class SubClass {
    static{
        System.out.println(SubClass.class);
    }

    public  static void main(String[] args){
       /* System.out.println(SubClass.value);*/
        SuperClass[] ss=new SuperClass[10];
      System.out.println(SuperClass.value);
    }
}
