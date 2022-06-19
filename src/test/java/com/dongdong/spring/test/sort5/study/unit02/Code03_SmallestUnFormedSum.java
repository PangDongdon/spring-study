package com.dongdong.spring.test.sort5.study.unit02;

import net.dongliu.commons.Sys;

public class Code03_SmallestUnFormedSum {

    public static int unformedSum(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;

        }
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            sum += arr[i];
        }
        //dp
        boolean[][] dp = new boolean[arr.length][sum  + 1];
        dp[0][arr[0]]=true;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i] == j) {
                    dp[i][j] = true;
                }
                if (dp[i - 1][j] || (j - arr[i] > -1 && dp[i - 1][j - arr[i]])) {
                    dp[i][j] = true;
                }
            }
        }
        for (int s = min; s <= sum; s++) {
            if (!dp[arr.length - 1][s]) {
                return s;

            }
        }
        return sum + 1;
    }

    public static void main(String[] args) {
      int[] aa=new int[]{25, 22, 9, 28, 8 ,14, 20 ,23 ,27, 16, 26, 19 ,21 ,14, 5, 30, 17 ,17, 13, 9, 27, 11, 23 ,9 ,2, 6 ,30 };
        System.out.println(unformedSum(aa));
    }
}
