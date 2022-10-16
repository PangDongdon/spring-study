package com.dongdong.spring.test.alBook.unit04Recursion;

/**
 * 最长公共子序列的问题
 */
public class Class10_MaxCommonSubsequenceProblem {

    public static String lce(String str1, String str2) {
        if (str1 == null || str2 == null || "".equals(str1) || "".equals(str2)) {
            return "";
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int[][] dp = getDp(chars1, chars2);
        int m = chars1.length - 1;
        int n = chars2.length - 1;
        char[] res = new char[dp[m][n]];
        int index = res.length - 1;
        while (index >= 0) {
            if (n > 0 && dp[m][n] == dp[m][n - 1]) {
                n--;
            } else if (m > 0 && dp[m][n] == dp[m - 1][n]) {
                m--;
            } else {
                res[index--] = chars1[m];
                n--;
                m--;
            }
        }
        return String.valueOf(res);
    }

    private static int[][] getDp(char[] chars1, char[] chars2) {
        int[][] dp = new int[chars1.length][chars2.length];
        dp[0][0] = chars1[0] == chars2[0] ? 1 : 0;
        for (int i = 1; i < chars1.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], chars1[i] == chars2[0] ? 1 : 0);
        }
        for (int j = 1; j < chars2.length; j++) {
            dp[0][j] = Math.max(dp[0][j - 1], chars2[j] == chars1[0] ? 1 : 0);
        }
        for (int i = 1; i < chars1.length; i++) {
            for (int j = 1; j < chars2.length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (chars1[i] == chars2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        String s1="1A2C3D4B56";
        String s2="B1D23CA45B6A";
        String lce = lce(s1,s2);
        System.out.println(lce);
    }
}
