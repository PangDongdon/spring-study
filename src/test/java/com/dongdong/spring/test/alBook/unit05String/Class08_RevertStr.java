package com.dongdong.spring.test.alBook.unit05String;

/**
 * 字符串的反转
 */
public class Class08_RevertStr {

    public static void rotateWord(char[] chars) {
        if (chars == null || chars.length == 0) {
            return;
        }
        //System.out.println(String.valueOf(chars));
        reverse(chars, 0, chars.length - 1);
        // System.out.println(String.valueOf(chars));
        int l = -1;
        int r = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                l = i == 0 || chars[i - 1] == ' ' ? i : l;
                r = i == chars.length - 1 || chars[i + 1] == ' ' ? i : r;
            }
            if (l != -1 && r != -1) {
                reverse(chars, l, r);
                l = -1;
                r = -1;
            }
        }
        System.out.println(String.valueOf(chars));
    }

    public static void reverse(char[] chars, int l, int r) {
        char temp = 0;
        while (l < r) {
            temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        String s = "dog loves pig";
        char[] chars = s.toCharArray();
        // reverse(chars, 0, s.length() - 1);
        rotateWord(chars);
    }

    public static void rotate1(char[] chars, int size) {
        if (chars == null || size <= 0 || size >= chars.length) {
            return;
        }
        reverse(chars, 0, size - 1);
        reverse(chars, size, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
    }

    public static void rotate2(char[] chars, int size) {
        if (chars == null || size <= 0 || size >= chars.length) {
            return;
        }
        int start = 0;
        int end = chars.length - 1;
        int lpart = size;
        int rpart = chars.length - size;
        int s = Math.min(lpart, rpart);
        int d = lpart - rpart;
        while (true) {
            exchange(chars, start, end, s);
            if (d == 0) {
                break;
            } else if (d > 0) {
                start += s;
                lpart = d;
            } else {
                end -= s;
                rpart -= d;
            }
            s = Math.min(lpart, rpart);
            d = lpart - rpart;
        }
    }

    public static void exchange(char[] chars, int start, int end, int size) {
        int i = end - size + 1;
        char tmp = 0;
        while (size-- != 0) {
            tmp = chars[start];
            chars[start] = chars[i];
            chars[i] = tmp;
            start++;
            i++;
        }
    }
}
