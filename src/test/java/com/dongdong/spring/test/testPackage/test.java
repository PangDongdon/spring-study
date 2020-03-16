package com.dongdong.spring.test.testPackage;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @Description:
 * @Date: 2019/11/19  15:32
 * @Author: dongdong
 */

public class test{


    public static void main(String[] args) throws Throwable {
        (new test().new Son()).thinking();
    }


  static class GrandFather {
    void thinking() throws Throwable {
        System.out.println(" i am grandfather");
    }
}

 static class Father extends  GrandFather{
    void thinking() throws Throwable {
        System.out.println(" i am father");
    }
}
 class Son extends  Father{
    void thinking() throws Throwable {
         try{
             MethodType mt=MethodType.methodType(void.class);
             MethodHandle mh=MethodHandles.lookup().findSpecial(GrandFather.class,"thinking",mt,getClass());
             mh.invoke(this);
         }catch(Exception e){
             e.getStackTrace();
         }
    }
}
}
