package com.dongdong.spring.test.alBook.unit05String;

/**
 * 0左边必为1的二进制字符串数量
 */
public class Class16_ZeroLeftIsOneStrCount {

    public static int getNum1(int n) {
        if (n < 1) {
            return 0;
        }
        return process(1, n);
    }

    private static int process(int i, int n) {
        if (i == n - 1) {
            return 2;
        }
        if (i == n) {
            return 1;
        }
        return process(i + 1, n) + process(i + 2, n);
    }

    public static int getNum2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int pre = 1;
        int cur = 1;
        int temp = 0;
        for (int i = 2; i <= n; i++) {
            temp = cur;
            cur += pre;
            pre = temp;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(getNum1(3));
        System.out.println(getNum2(3));
        System.out.println(getNum3(3));
    }

    public static int getNum3(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        int[][] base = {{1, 1}, {1, 0}};
        int[][] res = matrixPower(base, n - 2);
        return 2 * res[0][0] + res[1][0];
    }

    private static int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }
        int[][] tmp = m;
        for (; p != 0; p >>= 1) {
            if ((p & 1) != 0) {
                res = muliMatrix(res, tmp);
            }
            tmp = muliMatrix(tmp, tmp);
        }
        return res;
    }

    private static int[][] muliMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }
}
