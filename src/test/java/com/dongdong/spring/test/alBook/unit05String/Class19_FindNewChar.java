package com.dongdong.spring.test.alBook.unit05String;


/**
 * 找到指定的新类型字符
 */
public class Class19_FindNewChar {

    public static String pointNewChar(String s, int k) {
        if (s == null || s.equals("") || k <= 0 || k >= s.length()) {
            return "";
        }
        char[] chars = s.toCharArray();
        int uNum = 0;
        for (int i = k - 1; i >= 0; i--) {
            if (!isUpper(chars[i])) {
                break;
            }
            uNum++;
        }
        if ((uNum & 1) == 1) {
            return s.substring(k - 1, k + 1);
        }
        if (isUpper(chars[k])) {
            return s.substring(k, k + 2);
        }
        return String.valueOf(chars[k]);
    }


    //判断是否是大写字符
    private static boolean isUpper(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public static void main(String[] args) {
        String s = "aaABCDEcBCg";
        System.out.println(pointNewChar(s, 7));
        System.out.println(pointNewChar(s, 4));
        System.out.println(pointNewChar(s, 10));
    }
}
