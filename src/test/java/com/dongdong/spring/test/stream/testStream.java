package com.dongdong.spring.test.stream;

import java.util.HashSet;
import java.util.stream.IntStream;

/**
 * @Description:
 * @Date: 2020/5/19  16:24
 * @Author: dongdong
 */
public class testStream {

    public static void main(String[] args) {
        IntStream intStream=IntStream.builder().add(1).add(2).build();
      //  System.out.println(intStream.max().getAsInt());
       // System.out.println(intStream.allMatch(e->e*e>2));

        /*IntStream is=intStream.map(e->e*2+1);
        is.forEach(System.out::println);*/
//        HashSet<String> hashSet=new HashSet<>();
//        hashSet.add("dd");
        boolean ss=true;
        System.out.println();

    }
}
