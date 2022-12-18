package com.dongdong.spring.test.alBook.unit05String;

/**
 * 字符串的调整与替换
 */
public class Class07_ReplaceAndUpdateStr {

    public static void replace(char[] chars) {
        if (chars == null || chars.length == 0) {
            return;
        }
        int num = 0;
        int len = 0;
        for (len = 0; len < chars.length && chars[len] != 0; len++) {
            if (chars[len] == ' ') {
                num++;
            }
        }
        int j = len + num * 2 - 1;
        char[] chars1 = new char[j + 1];
        for (int i = len - 1; i > -1; i--) {
            if (chars[i] != ' ') {
                chars1[j--] = chars[i];
            } else {
                chars1[j--] = '0';
                chars1[j--] = '2';
                chars1[j--] = '%';
            }
        }
        printChar(chars1);
    }

    public static void modify(char[] chars) {
        if (chars == null || chars.length == 0) {
            return;
        }
        int j = chars.length - 1;
        for (int i = chars.length - 1; i > -1; i--) {
            if (chars[i] != '*') {
                chars[j--] = chars[i];
            }
        }
        for (; j > -1; ) {
            chars[j--] = '*';
        }
        printChar(chars);
    }

    public static void main(String[] args) {
        char[] chars = {'a', ' ', 'b', ' ', ' ', 'c'};
        replace(chars);
        System.out.println("\n");
        char[] chars1 = {'1', '2', '*', '*', '3', '4', '5'};
        modify(chars1);
    }

    public static void printChar(char[] chars) {
        for (char c : chars) {
            System.out.print(c + "");
        }
    }
}
