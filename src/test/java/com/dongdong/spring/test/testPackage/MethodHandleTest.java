package com.dongdong.spring.test.testPackage;

import org.apache.ibatis.javassist.bytecode.BootstrapMethodsAttribute;
import org.apache.poi.ss.formula.functions.Hlookup;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @Description:
 * @Date: 2019/11/19  11:48
 * @Author: dongdong
 */
public class MethodHandleTest {

    static class ClassA{
        public void println(String s){
            System.out.println(s);
        }

    }

    public static void main(String[] args)throws  Throwable{
        Object obj=System.currentTimeMillis()%2==0 ? System.out :new ClassA();
        getPrintnMH(obj).invokeExact("icyfenix");
    }
    private static MethodHandle getPrintnMH(Object reveier) throws Throwable{
        MethodType mt=MethodType.methodType(void.class,String.class);
        return MethodHandles.lookup().findVirtual(reveier.getClass(),"println",mt).bindTo(reveier);
    }
}
