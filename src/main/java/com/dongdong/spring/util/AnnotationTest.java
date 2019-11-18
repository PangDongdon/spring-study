package com.dongdong.spring.util;

/**
 * @Description:
 * @Date: 2019/11/5  14:53
 * @Author: dongdong
 */
@PersonAnnotation(name = "cc",age = 21)
public class AnnotationTest {
   /* @PersonAnnotation
    public static void getInformation(){

    }*/

    public static void main(String[] args){
        Class<AnnotationTest> cc=AnnotationTest.class;
        boolean aa=cc.isAnnotationPresent(PersonAnnotation.class);
        System.out.println(aa);
        PersonAnnotation personAnnotation=cc.getAnnotation(PersonAnnotation.class);
        System.out.println(personAnnotation.age()+"::"+personAnnotation.name());
    }
}
