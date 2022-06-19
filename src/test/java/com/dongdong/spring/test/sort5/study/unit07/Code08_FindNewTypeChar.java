package com.dongdong.spring.test.sort5.study.unit07;

import org.apache.commons.lang.StringUtils;

public class Code08_FindNewTypeChar {

    public static String pointNewchar(String s, int k) {
        if (StringUtils.isBlank(s) || k < 1 || k > s.length()) {
            return s;
        }
        char[] arr = s.toCharArray();
        int count = 0;
        //统计k之前大写字母的数量
        for (int i = k - 1; i > -1; i--) {
            if (!isUpper(arr[i])) {
                continue;
            }
            count++;
        }
        if ((count & 1) == 1) {
            return s.substring(k - 1, k + 1);
        }
        if (isUpper(arr[k])) {
            return s.substring(k, k + 2);
        }
        return String.valueOf(arr[k]);
    }

    static boolean isUpper(char c) {
        return !(c < 'A' || c > 'Z');
    }

    public static void main(String[] args) {
        String str = "aaABCDEcBCg";

        System.out.println(pointNewchar(str, 7));
        System.out.println(pointNewchar(str, 4));
        System.out.println(pointNewchar(str, 10));
    }
}
