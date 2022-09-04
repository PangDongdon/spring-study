package com.dongdong.spring.test.alBook.unit04Recursion;

//矩阵的最大路径
public class Class02_MatrixMaxPath {

    public static int minPathSum1(int[][] arr) {
        if (arr == null || arr.length < 1 || arr[0] == null || arr[0].length < 1) {
            return 0;
        }
        int[][] dp = new int[arr.length][arr[0].length];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }
        for (int j = 1; j < arr[0].length; j++) {
            dp[0][j] = dp[0][j - 1] + arr[0][j];
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
            }
        }
        return dp[arr.length - 1][arr.length - 1];
    }


    //空间压缩
    public static int minPathSum2(int[][] m) {
        if (m == null || m.length < 1 || m[0] == null || m[0].length < 1) {
            return 0;
        }
        int more = Math.max(m.length, m[0].length);//行数与列数较大的那个为more
        int less = Math.min(m.length, m[0].length);//行数与列数较大的那个为less
        boolean rowmore = more == m.length;//行数是不是大于或等于列数
        int[] arr = new int[less];//辅助数组的长度仅为行数与列数中的最小值
        arr[0] = m[0][0];
        for (int i = 1; i < less; i++) {
            arr[i] = arr[i - 1] + (rowmore ? m[0][i] : m[i][0]);
        }
        for (int i = 1; i < more; i++) {
            arr[0] = arr[0] + (rowmore ? m[0][i] : m[i][0]);
            for (int j = 1; j < less; j++) {
                arr[j] = Math.min(arr[j - 1], arr[j]) + (rowmore ? m[i][j] : m[j][i]);
            }
        }
        return arr[less - 1];
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        System.out.println(minPathSum2(arr));
    }
}
