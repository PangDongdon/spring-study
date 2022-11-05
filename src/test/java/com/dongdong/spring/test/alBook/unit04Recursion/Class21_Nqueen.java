package com.dongdong.spring.test.alBook.unit04Recursion;

/**
 * N皇后问题
 */
public class Class21_Nqueen {


    public static int num1(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process1(0, record, n);
    }

    public static int process1(int i, int[] record, int n) {
        if (i == 1) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(i + 1, record, n);
            }
        }
        return res;
    }

    private static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; i++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 1;
        int n2 = 2;
        int n3 = 8;
        System.out.println(num2(n));
        System.out.println(num2(n2));
        System.out.println(num2(n3));
    }

    public static int num2(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process2(0, record, n);
    }

    private static int process2(int i, int[] record, int n) {
        if (n == i) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid2(record, i, j)) {
                record[i] = j;
                res += process2(i + 1, record, n);
            }
        }
        return res;
    }

    private static boolean isValid2(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (record[k] == j || Math.abs(record[k] - j) == Math.abs(k - i)) {
                return false;
            }
        }
        return true;
    }

    public static int num3(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }
        int upperLim = n == 32 ? -1 : (1 << n) - 1;
        return process3(upperLim, 0, 0, 0);
    }

    private static int process3(int upperLim, int colLim, int leftDiaLim, int rightDiaLim) {
        if (colLim == upperLim) {
            return 1;
        }
        int pos = 0;
        int mostRightOne = 0;
        pos = upperLim & (~(colLim | leftDiaLim | rightDiaLim));
        int res = 0;
        while (pos != 0) {
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;
            res += process3(upperLim, colLim | mostRightOne, (leftDiaLim | mostRightOne) << 1, (rightDiaLim | mostRightOne) >>> 1);
        }
        return res;
    }

}
