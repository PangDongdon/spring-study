package com.dongdong.spring.leetcode;


/**
 * 最长有效括号
 */
public class Top90LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int n = s.length();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        for (int i=0;i<n;i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (right == left) {
                maxLength = Math.max(maxLength, right * 2);
            }
            if (right > left) {
                right = 0;
                left = 0;

            }
        }

        right = 0;
        left = 0;

        for (int i=n-1;i>0;i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (right == left) {
                maxLength = Math.max(maxLength, right * 2);
            }
            if (right < left) {
                right = 0;
                left = 0;
            }
        }
        return maxLength;
    }

}
