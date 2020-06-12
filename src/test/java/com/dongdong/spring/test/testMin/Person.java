package com.dongdong.spring.test.testMin;

import lombok.Data;

/**
 * @Description:
 * @Date: 2020/3/31  9:39
 * @Author: dongdong
 */
@Data
public class Person {
    private String  name;
    private int age;
    public Person(String name,int age){
        this.age=age;
        this.name=name;
    }
}
