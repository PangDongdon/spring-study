package com.dongdong.spring.test.collection;


import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Description:
 * @Date: 2020/6/12  11:10
 * @Author: dongdong
 */
public class ListTest {
    public static void main(String[] args) {
        List<Integer> list= Lists.newArrayList(1,2,3,4,5,6);
        System.out.println(Lists.partition(list,2));
    }
}
