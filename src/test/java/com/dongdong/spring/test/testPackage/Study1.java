package com.dongdong.spring.test.testPackage;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @Description:
 * @Date: 2019/11/12  19:13
 * @Author: dongdong
 */
public class Study1 {

    public static void main(String[] args) throws  Throwable{
        MethodType methodType=MethodType.methodType(Void.TYPE,double.class,Integer.class);
        MethodHandle methodHandle= MethodHandles.lookup().findVirtual(Test1.class,"do1",methodType);
        Test1 test1=new Test1(4);
        methodHandle.invokeExact(test1,5.1,new Integer(1));
       /* methodHandle.invokeExact(test1,5.1,1);*/
    }
}
