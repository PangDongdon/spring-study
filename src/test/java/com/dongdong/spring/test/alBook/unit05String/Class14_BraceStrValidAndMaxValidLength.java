package com.dongdong.spring.test.alBook.unit05String;

/**
 * 括号字符串的有效性和最长有效长度
 */
public class Class14_BraceStrValidAndMaxValidLength {

    private static boolean isValid(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        char[] chars = str.toCharArray();
        int count = 0;
        for (char c : chars) {
            if (c != '(' && c != ')') {
                return false;
            }
            if (c == '(') {
                count++;
            }
            if (c == ')' && --count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        String str = "(())";
        String str2 = "()(";
        System.out.println(isValid(str));
        System.out.println(isValid(str2));
    }

    public int maxLength(String str) {
        if (str == null || "".equals(str)) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int[] dp = new int[chars.length];
        int pre = 0;
        int res = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ')') {
                pre = i - dp[i - 1] - 1;
                if (pre >= 0 && chars[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
