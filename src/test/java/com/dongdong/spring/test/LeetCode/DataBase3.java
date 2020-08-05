package com.dongdong.spring.test.LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DataBase3 {
    //private static String s = "bbbbb";
    private static String s="abcabcbb";
    //private static String s="pwwkew";

    public static void main(String[] args) {
        int count2 = 0;
        //遍历字符串,去除可能的字符串
        for (int i = 0; i < s.length(); i++){
            for (int j = s.length(); j > i; j--){
                //记录每次最长长度
                int count = 0;
                String s1 = s.substring(i,j);
                char[] a = s1.toCharArray();
                List<String> list = new ArrayList<>();
                for (char c : a) {
                    String s = String.valueOf(c);
                    list.add(s);
                }
                //去除重复字符串
                List<String> list2 = list.stream().distinct().collect(Collectors.toList());
                if (list.size() == list2.size()) {
                    count = list.size();
                    if (count2 < count) {
                        //记录最长字符串
                        count2 = count;
                        //打印出最长字符串
                        System.out.println(list);
                    }
                }
            }
        }
        System.out.println(count2);
    }

         @Test
        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            Set<Character> set = new HashSet<>();
            int ans = 0, i = 0, j = 0;
            while (i < n && j < n) {
                // try to extend the range [i, j]
                if (!set.contains(s.charAt(j))){
                    set.add(s.charAt(j++));
                    ans = Math.max(ans, j - i);
                }
                else {
                    set.remove(s.charAt(i++));
                }
            }
            return ans;
        }




}
