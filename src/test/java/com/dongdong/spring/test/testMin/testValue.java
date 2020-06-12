package com.dongdong.spring.test.testMin;

import org.assertj.core.util.Lists;

import java.util.List;

/**
 * @Description:
 * @Date: 2020/3/31  9:40
 * @Author: dongdong
 */
public class testValue {

    public static void main(String[] args){
        Person p1=new Person("dd",23);
        Person p2=new Person("ss",22);
        Person p3=new Person("ss",20);
        List<Person> ll= Lists.newArrayList();
        ll.add(p1);
        ll.add(p2);
        ll.add(p3);
       System.out.println(ll.stream().min((x,y)->x.getAge()>y.getAge()? 1:0));
    }
}
