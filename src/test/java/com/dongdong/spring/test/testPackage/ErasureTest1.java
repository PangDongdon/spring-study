package com.dongdong.spring.test.testPackage;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Date: 2019/11/22  13:52
 * @Author: dongdong
 */
public class ErasureTest1 {

    public static void main(String[] args){
        List<Integer> list1=new ArrayList<>();
        list1.add(1);
        list1.add(2);
        List list=list1;
        System.out.println(String.valueOf(list.get(0)));
    }
}
