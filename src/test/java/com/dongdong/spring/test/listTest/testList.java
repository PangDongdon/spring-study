package com.dongdong.spring.test.listTest;

import org.assertj.core.util.Lists;

import java.util.ArrayList;

/**
 * @Description:
 * @Date: 2020/5/18  11:32
 * @Author: dongdong
 */
public class testList {

    public static void main(String[] args) {
        ArrayList<String> list= Lists.newArrayList();
        ArrayList<String> list11= Lists.newArrayList();
        list.add("1");
        list.add("2");
        list11.add("1");
        list11.add("222");
        System.out.println(list.retainAll(list11)+","+list);
    }
}
