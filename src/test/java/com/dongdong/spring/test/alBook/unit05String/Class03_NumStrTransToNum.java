package com.dongdong.spring.test.alBook.unit05String;

/**
 * 将整数字符串转化为整数值
 */
public class Class03_NumStrTransToNum {

    public static boolean isValid(char[] chars) {
        if (chars[0] != '-' && (chars[0] < '0' || chars[0] > '9')) {
            return false;
        }
        if (chars[0] == '-' && (chars.length == 1 || chars[1] == '0')) {
            return false;
        }
        if (chars[0] == '0' && chars.length > 1) {
            return false;
        }
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                return false;
            }
        }
        return true;
    }

    public static int convert(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        char[] chars = str.toCharArray();
        if (!isValid(chars)) {
            return 0;
        }
        boolean posi = chars[0] == '-' ? false : true;
        int minq = Integer.MIN_VALUE / 10;
        int minr = Integer.MIN_VALUE % 10;
        int res = 0;
        int cur = 0;
        for (int i = posi ? 0 : 1; i < chars.length; i++) {
            cur = '0' - chars[i];
            if ((res < minq) || (res == minq && cur < minr)) {
                return 0;
            }
            res = res * 10 + cur;
            if (posi && res == Integer.MIN_VALUE) {
                return 0;
            }
        }
        return posi ? -res : res;
    }

    public static void main(String[] args) {
        System.out.println(convert("123"));
        System.out.println(convert("023"));
        System.out.println(convert("A13"));
        System.out.println(convert("0"));
        System.out.println(convert("2147483647"));
        System.out.println(convert("2147483648"));
        System.out.println(convert("-123"));
    }
}
