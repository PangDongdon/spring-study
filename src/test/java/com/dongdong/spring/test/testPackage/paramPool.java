package com.dongdong.spring.test.testPackage;

/**
 * @Description:
 * @Date: 2019/10/17  10:55
 * @Author: dongdong
 */
public class paramPool {

    public  static void main(String[] args){
        String str2=new String("计算机vvvv");
       // String str1="计算机vvvv";
        System.out.println(str2.intern()==str2);
    }



}
