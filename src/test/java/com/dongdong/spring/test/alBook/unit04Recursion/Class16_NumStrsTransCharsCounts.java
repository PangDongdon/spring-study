package com.dongdong.spring.test.alBook.unit04Recursion;

/**
 * 数字字符串转化为字母组合的种数
 */
public class Class16_NumStrsTransCharsCounts {

    public static int num1(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        char[] chars = str.toCharArray();
        return process(chars, 0);
    }

    private static int process(char[] chars, int i) {
        if (chars.length == i) {
            return 1;
        }
        if (chars[i] == '0') {
            return 0;
        }
        int res = process(chars, i + 1);
        if (i + 1 < chars.length && (chars[i] - '0') * 10 + chars[i + 1] - '0' < 27) {
            res += process(chars, i + 2);
        }
        return res;
    }

    public static int num2(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int cur = chars[chars.length - 1] == '0' ? 0 : 1;
        int next = 1;
        int temp = 0;
        for (int i = chars.length - 2; i >= 0; i--) {
            if (chars[i] == '0') {
                next = cur;
                cur = 0;
            } else {
                temp = cur;
                if ((chars[i] - '0') * 10 + chars[i + 1] - '0' < 27) {
                    cur += next;
                }
                next = temp;
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        String str = "1111";
        System.out.println(num1(str));
        System.out.println(num2(str));
    }
}
