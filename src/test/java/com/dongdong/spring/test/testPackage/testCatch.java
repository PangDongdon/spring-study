package com.dongdong.spring.test.testPackage;

/**
 * @Description:
 * @Date: 2019/12/27  15:50
 * @Author: dongdong
 */
public class testCatch {

    public static void main(String[] args){
        test12();
        test1();
    }

    private static int  test1(){
        int a=6/2;
        System.out.println(a);
        return a;
    }

    private static int  test12(){
        try {
            int a = 6 / 0;
            return a;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
