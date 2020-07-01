package com.dongdong.spring.test.testPackage;

import net.dongliu.commons.Sys;

/**
 * @Description:
 * @Date: 2020/6/18  16:08
 * @Author: dongdong
 */
public class InitTest {


   static class A{
        public  static int a=3;
        static {
            System.out.println("A");
        }
    }

    static class B extends  A{
       static {
           System.out.println("B");
       }
    }

    public static void main(String[] args) {
        System.out.println(A.a);
    }



}
