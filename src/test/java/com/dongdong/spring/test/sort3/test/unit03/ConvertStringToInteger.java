package com.dongdong.spring.test.sort3.test.unit03;

import org.apache.logging.log4j.util.Strings;

public class ConvertStringToInteger {

    public static int convert(String s) throws Exception {
        if (Strings.isBlank(s)) {
          return 0;
        }
        char[] chars = s.toCharArray();
        if (!isValid(chars)) {
            return 0;
        }
        //判断是否是正数
        boolean postive = chars[0] != '-';
        int cur = 0;
        int res = 0;
        int s1 = Integer.MIN_VALUE / 10;
        int s2 = Integer.MIN_VALUE % 10;
        for (int i = postive ? 0 : 1; i < chars.length; i++) {
            cur = '0' - chars[i];
            if (res < s1 || (s1 == res && cur<s2)) {
                return 0;
            }
            res=res*10+cur;
        }
        if(postive && res==Integer.MIN_VALUE){
            return 0;
        }
        res=postive?-res:res;
        return res;
    }

    private static boolean isValid(char[] chars) throws Exception {
        if (chars[0] != '-' && (chars[0] < '0' || chars[0] > '9')) {
            return false;
        }
        if (chars[0] == '-' && (chars[1] == '0') || chars.length == 1) {
            return false;
        }
        if (chars[0] == '0' && (chars.length > 1)) {
            return false;
        }
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        String test1 = "2147483647"; // max in java
        System.out.println(convert(test1));

        String test2 = "-2147483648"; // min in java
        System.out.println(convert(test2));

        String test3 = "2147483648"; // overflow
        System.out.println(convert(test3));

        String test4 = "-2147483649"; // overflow
        System.out.println(convert(test4));

        String test5 = "-123";
        System.out.println(convert(test5));
    }


    //2147483647
    //-2147483648
    //0
    //0
    //-123
}
