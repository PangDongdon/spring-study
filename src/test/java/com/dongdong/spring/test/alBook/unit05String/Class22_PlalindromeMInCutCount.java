package com.dongdong.spring.test.alBook.unit05String;

/**
 * 回文最少分割数
 */
public class Class22_PlalindromeMInCutCount {

    public static int minCut(String str) {
        if (str == null || "".equals(str)) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int len = chars.length;
        int[] dp = new int[len + 1];
        boolean[][] b = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j < len; j++) {
                if (chars[i] == chars[j] && (j - i < 2 || b[i + 1][j - 1])) {
                    b[i][j] = true;
                    dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        String s = "ABA";
        String s1 = "ACDCDCDAD";
        System.out.println(minCut(s));
        System.out.println(minCut(s1));
    }

}
