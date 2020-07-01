package com.dongdong.spring.test.annotation;

import net.dongliu.commons.Sys;

import java.lang.annotation.Annotation;

/**
 * @Description:
 * @Date: 2020/6/29  16:09
 * @Author: dongdong
 */

@GetName
public class InheritableTest  extends  InheritableTest2{
    public static void main(String[] args) {
      //  System.out.println(InheritableTest.class.isAnnotationPresent(Inheritable.class));
        Annotation[] annotations=  InheritableTest.class.getAnnotations();
        for(Annotation annotation:annotations){
            System.out.println(annotation.getClass().getName());
        }
    }
}

