package com.dongdong.spring.test.compare;

import java.util.Comparator;

/**
 * @Description: Comparator 比较器
 * @Date: 2020/9/1  13:11
 * @Author: dongdong
 */
public class ComparatorTest implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2){
        return o2.getAge()-o1.getAge();
    }
}
