package com.dongdong.spring.leetcodetop100_3;

/**
 * 最大有效括号
 */
public class Top93LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, max = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if ('(' == s.charAt(i)) {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, left * 2);
            }
            if (right> left ) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = n - 1; i >= 0; i--) {
            if ('(' == s.charAt(i)) {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, left * 2);
            }
            if (left > right) {
                left = right = 0;
            }
        }
        return max;
    }
}
