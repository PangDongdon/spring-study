package com.dongdong.spring.test.jvm.jvmLoad;

import org.springframework.web.servlet.tags.Param;

/**
 * @Description:
 * @Date: 2020/11/4  18:00
 * @Author: dongdong
 */
public class InitClass {

    static  class Parent{

        public static int A=1;
        static {
            A=2;
        }
    }

    static class  Sub extends Parent{
        public  static int B=A;
    }

    public static void main(String[] args) {
        System.out.println("ddd.class".substring(0,"ddd.class".lastIndexOf(".")));
    }
}
