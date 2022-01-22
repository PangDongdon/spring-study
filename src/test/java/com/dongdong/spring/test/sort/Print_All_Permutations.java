package com.dongdong.spring.test.sort;

import java.util.HashSet;

public class Print_All_Permutations {

    public static void printPermutations(String s) {
        char[] chars = s.toCharArray();
        process1(chars, 0);
    }

    public static void process1(char[] chars, int i) {
        if (i == chars.length) {
            System.out.println("print: " + String.valueOf(chars));
            return;
        }
        for (int j = i; j < chars.length; j++) {
            swap(chars, i, j);
            process1(chars, i + 1);
            swap(chars, i, j);
        }
    }


    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }


    public static void printPermutations2(String s) {
        char[] chars = s.toCharArray();
        process2(chars, 0);
    }

    public static void process2(char[] chars, int i) {
        if (i == chars.length) {
            System.out.println("print: " + String.valueOf(chars));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int j = i; j < chars.length; j++) {
            if (!set.contains(chars[j])) {
                set.add(chars[j]);
                swap(chars, i, j);
                process2(chars, i + 1);
                swap(chars, i, j);
            }
        }
    }

    public static void main(String[] args) {
        String test1 = "abc";
        printPermutations(test1);

        String test2 = "acc";
        printPermutations2(test2);
    }
}
