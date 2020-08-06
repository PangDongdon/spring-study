package com.dongdong.spring.test.collection;







import org.springframework.context.ApplicationContext;

import java.util.HashMap;

/**
 * @Description:
 * @Date: 2020/8/6  9:48
 * @Author: dongdong
 */
public class HashMapTest {

    public static void main(String[] args) {
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("1","dd");
        hashMap.put("2","pdd");
        System.out.println(hashMap);
    }
}

