package com.dongdong.spring.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 */
public class Top8LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int n = s.length();
        int right = -1;
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                set.remove(s.charAt(i));
            }
            while (right + 1 < n && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                ++right;
            }
            ans = Math.max(ans, right - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring(s2));
        System.out.println(lengthOfLongestSubstring(s3));
    }
}
