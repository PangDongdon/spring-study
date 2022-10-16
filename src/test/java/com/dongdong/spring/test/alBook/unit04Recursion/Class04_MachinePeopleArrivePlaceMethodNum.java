package com.dongdong.spring.test.alBook.unit04Recursion;

//机器人到达指定位置方法数
public class Class04_MachinePeopleArrivePlaceMethodNum {

    // N :1-N 个位置
    // M: M 当前的位置
    // K:还剩K次
    //:P 目标位置
    //递归解法
    public static int walk(int N, int M, int K, int P) {
        if (K == 0) {
            return M == P ? 1 : 0;
        }
        if (M == 1) {
            return walk(N, 2, K - 1, P);
        }
        if (M == N) {
            return walk(N, M - 1, K - 1, P);
        }
        return walk(N, M - 1, K - 1, P) + walk(N, M + 1, K - 1, P);
    }

    public static int ways1(int N, int M, int K, int P) {
        if (N < 2 || M < 1 || K < 1 || P < 1 || M > N || P > N) {
            return 0;
        }
        return walk(N, M, K, P);
    }

    public static int ways2(int N, int M, int K, int P) {
        if (N < 2 || M < 1 || K < 1 || P < 1 || M > N || P > N) {
            return 0;
        }
        int[][] dp = new int[K + 1][N + 1];
        dp[0][P] = 1;
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i - 1][2];
                } else if (j == N) {
                    dp[i][j] = dp[i - 1][N - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }
            }
        }
        return dp[K][M];
    }

    public static void main(String[] args) {
        //System.out.println(ways1(5, 2, 3, 3));
        System.out.println(ways1(7, 4, 9, 5));
        // System.out.println(ways2(5, 2, 3, 3));
        System.out.println(ways2(7, 4, 9, 5));
    }
}
