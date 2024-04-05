package com.dongdong.spring.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Top9FindAnagrams {

    public static List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        char[] chp = p.toCharArray();
        Arrays.sort(chp);
        for (int i = 0; i <= s.length() - p.length(); i++) {
            char[] ch = new char[p.length()];
            //获取窗口的数据
            for (int j = i, z = 0; j < i + p.length(); j++, z++) {
                ch[z] = s.charAt(j);
            }
            Arrays.sort(ch);
            //符合条件的结果记录下
            if (Arrays.toString(ch).equals(Arrays.toString(chp))) {
                res.add(i);
            }
        }
        return res;
    }

    public static List<Integer> findAnagrams2(String s, String p) {
        if (s == null || p == null || s.length() < p.length()) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int sl = s.length();
        int pl = p.length();
        int[] sArray = new int[26];
        int[] pArray = new int[26];
        for (int i = 0; i < pl; i++) {
            ++sArray[s.charAt(i) - 'a'];
            ++pArray[p.charAt(i) - 'a'];
        }
        if (Arrays.equals(sArray, pArray)) {
            res.add(0);
        }
        for (int i = 0; i < sl - pl; i++) {
            --sArray[s.charAt(i) - 'a'];
            ++sArray[s.charAt(i + pl) - 'a'];
            if (Arrays.equals(sArray, pArray)) {
                res.add(i + 1);
            }
        }
        return res;
    }


    public static void main(String[] args) {
     /*   输入: s = "cbaebabacd", p = "abc"
        输出: [0,6]

        输入: s = "abab", p = "ab"
        输出: [0,1,2]*/

        String s1 = "cbaebabacd";
        String s2 = "abc";
        String s3 = "abab";
        String s4 = "ab";
        System.out.println(findAnagrams(s1, s2));
        System.out.println(findAnagrams2(s3, s4));
    }
}
