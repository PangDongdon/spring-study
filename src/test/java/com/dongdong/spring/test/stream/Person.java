package com.dongdong.spring.test.stream;

import java.io.Serializable;

/**
 * @Description:
 * @Date: 2020/7/16  13:51
 * @Author: dongdong
 */
public class Person implements Serializable {
    private String name;
    private String age;

    public Person(String name, String age) {
        System.out.println("有参构造器");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
