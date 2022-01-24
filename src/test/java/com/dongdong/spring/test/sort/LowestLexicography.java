package com.dongdong.spring.test.sort;

import java.util.Arrays;
import java.util.Comparator;

public class LowestLexicography {

    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return (o1+o2).compareTo(o2+o1);
        }
    }

    public static String  lowestString(String[] arr){
        if(arr==null || arr.length==0){
            return "";
        }
        Arrays.sort(arr,new MyComparator());
        String res="";
        for(String s:arr){
            res+=s;
        }
        return  res;
    }

    public static void main(String[] args) {
        String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw" };
        System.out.println(lowestString(strs1));

        String[] strs2 = { "ba", "b" };
        System.out.println(lowestString(strs2));

    }
}
