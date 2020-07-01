package com.dongdong.spring.test.annotation;

import net.dongliu.commons.Sys;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Date: 2020/6/29  17:01
 * @Author: dongdong
 */

public class ProcessorTest {

    public static void main(String clazz) throws ClassNotFoundException {
        int passed=0;
        int failed =0;

        for(Method m:Class.forName(clazz).getMethods()){
            if(m.isAnnotationPresent(Testable.class)){
                try{
                    m.invoke(null);
                    passed++;
                }catch(Exception ex){
                    System.out.println("运行fail,fail message is"+ex.getMessage());
                    failed++;
                }
            }

        }
        System.out.println("run success"+passed+"run failed"+failed);
    }
}
