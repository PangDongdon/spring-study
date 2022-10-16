package com.dongdong.spring.test.alBook.unit04Recursion;

public class Class11_MaxCommonSubstringProblem {

    public static String lcst1(String s1, String s2) {
        if (s1 == null || s2 == null || "".equals(s1) || "".equals(s2)) {
            return "";
        }
        int max = 0;
        int end = 0;
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int[][] dp = getdp(chars1, chars2);
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                if (dp[i][j] > max) {
                    end = i;
                    max = dp[i][j];
                }
            }
        }
        return s1.substring(end - max + 1, end + 1);
    }

    private static int[][] getdp(char[] chars1, char[] chars2) {
        int[][] dp = new int[chars1.length][chars2.length];
        for (int i = 0; i < chars1.length; i++) {
            dp[i][0] = chars1[i] == chars2[0] ? 1 : 0;
        }

        for (int j = 0; j < chars2.length; j++) {
            dp[j][0] = chars2[j] == chars1[0] ? 1 : 0;
        }

        for (int i = 1; i < chars1.length; i++) {
            for (int j = 1; j < chars2.length; j++) {
                if (chars1[i] != chars2[j]) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        return dp;
    }

    public static String lcst2(String s1, String s2) {
        if (s1 == null || s2 == null || "".equals(s1) || "".equals(s2)) {
            return "";
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int row = 0;
        int col = chars2.length - 1;
        int max = 0;
        int end = 0;
        while (row < chars1.length) {
            int i = row;
            int j = col;
            int len = 0;
            while (i < chars1.length && j < chars2.length) {
                if (chars1[i] == chars2[j]) {
                    len++;
                } else {
                    len = 0;
                }
                if (len > max) {
                    end = i;
                    max = len;
                }
                i++;
                j++;
            }
            if (col > 0) {
                col--;
            } else {
                row++;
            }
        }
        return s1.substring(end - max + 1, end + 1);
    }

    public static void main(String[] args) {
        String s1 = "1AB2345CD";
        String s2 = "12345EF";
        System.out.println(lcst1(s1, s2));
        System.out.println(lcst2(s1, s2));

    }
}
