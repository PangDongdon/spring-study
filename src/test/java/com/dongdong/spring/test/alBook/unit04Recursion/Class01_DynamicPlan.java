package com.dongdong.spring.test.alBook.unit04Recursion;

//斐波那契数列问题的递归和动态规划
public class Class01_DynamicPlan {

    //(F(n),F(n-1))=(F(n-1),F(n-2))x|a,b|
    //                             x|c,d|
    //斐波那契数列（递归）//O(2^n)
    private static int f1(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return f1(n - 1) + f1(n - 2);
    }

    //O(n)
    public static int f2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int res = 1;
        int temp = 0;
        int pre = 1;
        for (int i = 3; i < n + 1; i++) {
            temp = res;
            res = pre + res;
            pre = temp;
        }
        return res;
    }

    public static int[][] matriPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        //先把res 设为单位矩阵，相等于整数中的1
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

    public static int[][] muliMatrix(int[][] m1, int[][] m2) {
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

    //O(logn)
    public static int f3(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[][] base = {{1, 1}, {1, 0}};
        int[][] res = matriPower(base, n - 2);
        return res[0][0] + res[1][0];
    }

    public static void main(String[] args) {
        System.out.println(f2(4));
        System.out.println(f1(4));
        System.out.println(f3(4));
    }

}
