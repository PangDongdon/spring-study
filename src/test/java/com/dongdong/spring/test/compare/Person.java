package com.dongdong.spring.test.compare;

import lombok.Data;

/**
 * @Description:
 * @Date: 2020/9/1  17:09
 * @Author: dongdong
 */
@Data
public class Person implements  Comparable<Person>  {
    private String  name;
    int age;

    public Person(String name,int age){
        this.age=age;
        this.name=name;
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }
}
