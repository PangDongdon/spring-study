package com.dongdong.spring.test.alBook.unit05String;

import com.dongdong.spring.test.javaDesignModel13.LeaveRequest;

/**
 * 旋变字符串问题
 */
public class Class20_RotateStrProblem {


    public static boolean sameTypeSameNumber(char[] str1, char[] str2) {
        if (str1.length != str2.length) {
            return false;
        }
        int[] map = new int[256];
        for (int i = 0; i < str1.length; i++) {
            map[str1[i]]++;
        }
        for (int i = 0; i < str2.length; i++) {
            if (--map[str2[i]] < 0) {
                return false;
            }
        }
        return true;
    }

    //在str1 中的这一段和str2中的这一段一定是等长的，所以只是一个size 参数
    public static boolean process(char[] str1, char[] str2, int L1, int L2, int size) {
        if (size == 1) {
            return str1[L1] == str2[L2];
        }
        //枚举每一种情况，有一个计算出互为旋转就返回true,都算不出来则返回false
        for (int leftPart = 1; leftPart < size; leftPart++) {
            if (process(str1, str2, L1, L2, leftPart) && process(str1, str2, L1 + leftPart, L2 + leftPart, size - leftPart)
                    || (process(str1, str2, L1, L2 + size - leftPart, leftPart) && process(str1, str2, L1 + leftPart, L2, size - leftPart))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isScramble1(String s1, String s2) {
        if ((s1 == null && s2 != null) || (s1 != null && s2 == null)) {
            return false;
        }
        if (s1 == null && s2 == null) {
            return true;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        if (!sameTypeSameNumber(str1, str2)) {
            return false;
        }
        int N = s1.length();
        return process(str1, str2, 0, 0, N);
    }


    public static boolean isScramble2(String s1, String s2) {
        if ((s1 == null && s2 != null) || (s1 != null && s2 == null)) {
            return false;
        }
        if (s1 == null && s2 == null) {
            return true;
        }
        if (s1.equals(s2)) {
            return true;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        if (!sameTypeSameNumber(str1, str2)) {
            return false;
        }
        int N = s1.length();
        boolean[][][] dp = new boolean[N][N][N + 1];
        for (int L1 = 0; L1 < N; L1++) {
            for (int L2 = 0; L2 < N; L2++) {
                dp[L1][L2][1] = str1[L1] == str2[L2];
            }
        }

        for (int size = 2; size <= N; size++) {
            for (int L1 = 0; L1 <= N - size; L1++) {
                for (int L2 = 0; L2 <= N - size; L2++) {
                    for (int leftSize = 1; leftSize < size; leftSize++) {
                        if (dp[L1][L2][leftSize] && dp[L1 + leftSize][L2 + leftSize][size - leftSize]
                                || (dp[L1][L2 + size - leftSize][leftSize] && dp[L1 + leftSize][L2][size - leftSize])) {
                            dp[L1][L2][size] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][N];
    }

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "dbac";
        System.out.println(isScramble1(s1, s2));
        System.out.println(isScramble2(s1, s2));
    }
}
