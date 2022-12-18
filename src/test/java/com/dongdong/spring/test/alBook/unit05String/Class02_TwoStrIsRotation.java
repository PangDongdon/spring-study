package com.dongdong.spring.test.alBook.unit05String;

import com.dongdong.spring.test.alBook.unit09Other.Classn_KMP;

/**
 * 判断两个字符串是否为旋转词
 */
public class Class02_TwoStrIsRotation {

    public static boolean isRotation(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        String s = s2 + s2;
        return  Classn_KMP.getIndexOf(s,s1)!=-1;
    }

    public static void main(String[] args) {
        String s1="cdab";
        String s2="abcd";
        System.out.println(isRotation(s1,s2));
        String s3="1ab2";
        String s4="ab12";
        System.out.println(isRotation(s3,s4));
        String s5="2ab1";
        String s6="ab12";
        System.out.println(isRotation(s5,s6));
        String s7="1QWERGVGGHH";
        String s8="WER";
        System.out.println(Classn_KMP.getIndexOf(s7,s8));
    }
}
