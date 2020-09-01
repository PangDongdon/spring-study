package com.dongdong.spring.test.compare;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Description:
 * @Date: 2020/9/1  17:10
 * @Author: dongdong
 */
public class TestCompare {

    @Test
    public void test(){

        ArrayList<Person> list=new ArrayList<>();
        list.add(new Person("aaa",10));
        list.add(new Person("bbb",21));
        list.add(new Person("ccc",20));
        //Collections.sort(list);
        Collections.sort(list,new ComparatorTest());
        System.out.println(list);
    }
}
