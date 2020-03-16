package com.dongdong.spring.test.testPackage;

/**
 * @Description:
 * @Date: 2019/11/21  15:29
 * @Author: dongdong
 */
public class ReflectTest {

    public static void   main(String[] args) throws ClassNotFoundException {
        // Three Method to use reflection method get class name,the first method always to use
        System.out.println(Class.forName("java.lang.String").getName());
        System.out.println(String.class.getName());
        System.out.println(new String().getClass().getName());
    }

}
