package com.dongdong.spring.test.sort3.test.unit02;

import javax.validation.constraints.Max;

public class Longest_Increasing_Path_in_a_Matrix {

    public static int longestIncreasingPath(int[][] m) {
        if (m == null || m.length < 1 || m[0].length < 1) {
            return 0;
        }
        int[][] h = new int[m.length][m[0].length];
        int max = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                //向下
                max = Math.max(max, maxIncrease(m, h, i + 1, j, m[i][j]) + 1);
                //向右
                max = Math.max(max, maxIncrease(m, h, i, j + 1, m[i][j]) + 1);
                //向上
                max = Math.max(max, maxIncrease(m, h, i - 1, j, m[i][j]) + 1);
                //向左
                max = Math.max(max, maxIncrease(m, h, i, j - 1, m[i][j]) + 1);
            }
        }
        return max;
    }

    public static int maxIncrease(int[][] m, int[][] h, int i, int j, int p) {
        if (i < 0 || i >= m.length || j < 0 || j >= m[0].length || m[i][j] >= p) {
            return 0;
        }
        if (h[i][j] == 0) {
            //向下走
            h[i][j] = maxIncrease(m, h, i + 1, j, m[i][j]) + 1;
            //向右
            h[i][j] = Math.max(h[i][j], maxIncrease(m, h, i, j + 1, m[i][j]) + 1);
            //向上
            h[i][j] = Math.max(h[i][j], maxIncrease(m, h, i - 1, j, m[i][j]) + 1);
            //向左
            h[i][j] = Math.max(h[i][j], maxIncrease(m, h, i, j - 1, m[i][j]) + 1);
        }
        return h[i][j];
    }

    public static int maxIncrease2(int[][] m, int[][] h, int i, int j, int p) {
        if (i < 0 || i >= m.length || j < 0 || j >= m[0].length || m[i][j] >= p) {
            return 0;
        }
        if (h[i][j] == 0) {
            h[i][j] = maxIncrease(m, h, i + 1, j, m[i][j]) + 1;
            h[i][j] = Math.max(h[i][j], maxIncrease(m, h, i, j + 1, m[i][j]) + 1);
            h[i][j] = Math.max(h[i][j], maxIncrease(m, h, i - 1, j, m[i][j]) + 1);
            h[i][j] = Math.max(h[i][j], maxIncrease(m, h, i, j - 1, m[i][j]) + 1);
        }
        return h[i][j];
    }

    public static void main(String[] args) {
        int[][] ss = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(longestIncreasingPath(ss));
    }
}
