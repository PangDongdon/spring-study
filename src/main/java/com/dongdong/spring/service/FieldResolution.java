package com.dongdong.spring.service;

import org.junit.Test;

/**
 * @Description:
 * @Date: 2019/11/15  11:03
 * @Author: dongdong
 */
public class FieldResolution {
    static {
        int   i=0;
    }
    static int c=0;
    interface  InterFace0{
        int A=0;
    }
    interface  Interface1 extends  InterFace0{
        int A=1;
    }
    interface  Interface2{
        int A=2;

    }
    static class Parent implements Interface1{
        public static int A=3;
    }
    static class Sub extends Parent implements  Interface2{
        public static int A=4;
    }
    public static void main(String[] args){
        System.out.println(Sub.A);
    }

    @Test
    public void  testStatic(){



    }
}
