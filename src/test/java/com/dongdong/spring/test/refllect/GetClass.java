package com.dongdong.spring.test.refllect;


import java.lang.reflect.InvocationTargetException;

/**
 * @Description:
 * @Date: 2020/8/5  13:46
 * @Author: dongdong
 */
public class GetClass {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Person person=new Person();
        System.out.println(person.getClass());
        System.out.println(Person.class);
        System.out.println(Class.forName("com.dongdong.spring.test.refllect.Person"));
        System.out.println(person.getClass().getConstructor().newInstance());
    }
}
