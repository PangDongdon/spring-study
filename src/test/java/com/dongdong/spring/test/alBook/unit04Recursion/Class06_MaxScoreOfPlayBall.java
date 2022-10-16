package com.dongdong.spring.test.alBook.unit04Recursion;

import java.util.concurrent.ArrayBlockingQueue;

//打气球的最大分数
public class Class06_MaxScoreOfPlayBall {

    public static int getMaxCoins1(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int[] help = new int[arr.length + 2];
        help[0] = 1;
        help[arr.length + 1] = 1;
        for (int i = 0; i < arr.length; i++) {
            help[i + 1] = arr[i];
        }
        return process(help, 1, arr.length);
    }

    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L - 1] * arr[L] * arr[R + 1];
        }
        int max = Math.max(arr[L - 1] * arr[L] * arr[R + 1] + process(arr, L + 1, R),
                arr[L - 1] * arr[R] * arr[R + 1] + process(arr, L, R - 1));
        for (int i = L + 1; i < R; i++) {
            max = Math.max(max,
                    arr[L - 1] * arr[i] * arr[R + 1] + process(arr, L, i - 1) + process(arr, i + 1, R));
        }
        return max;
    }

    public static int getMaxCoins2(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int N = arr.length;
        int[] help = new int[N + 2];
        help[0] = 1;
        help[N + 1] = 1;
        for (int i = 0; i < arr.length; i++) {
            help[i + 1] = arr[i];
        }
        int[][] dp = new int[N + 2][N + 2];
        for (int L = N; L >= 1; L--) {
            for (int R = L + 1; R <= N; R++) {
                int finalL = help[L - 1] * help[L] * help[R + 1] + process(help, L + 1, R);
                int finalR = help[L - 1] * help[R] * help[R + 1] + process(help, L, R - 1);
                dp[L][R] = Math.max(finalL, finalR);
                for (int i = L + 1; i < R; i++) {
                    dp[L][R] = Math.max(dp[L][R],
                            help[L - 1] * help[i] * help[R + 1]
                                    + process(help, L, i - 1) + process(help, i + 1, R));
                }
            }
        }
        return dp[1][N];
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 5, 1, 6};
        int[] arr2 = {3, 2, 5};
        System.out.println(getMaxCoins1(arr));
        System.out.println(getMaxCoins1(arr2));
        System.out.println("=========method2============");
        System.out.println(getMaxCoins2(arr));
        System.out.println(getMaxCoins2(arr2));
    }
}
