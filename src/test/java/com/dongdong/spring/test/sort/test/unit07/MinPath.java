package com.dongdong.spring.test.sort.test.unit07;

public class MinPath {

    public static int getMinPath(int[][] arr) {
        if (arr == null || arr.length<1 || arr[0] == null || arr[0].length < 1) {
            return 0;
        }
        return process(arr, 0, 0);
    }

    private static int process(int[][] arr, int i, int j) {
        if (i == arr.length - 1 && j == arr[0].length - 1) {
            return arr[i][j];
        }
        if (i == arr.length - 1) {
            return arr[i][j] + process(arr, i, j + 1);
        }
        if (j == arr[0].length - 1) {
            return arr[i][j] + process(arr, i+1, j);
        }
        return arr[i][j] + Math.min(process(arr, i, j + 1), process(arr, i + 1, j));
    }

    private static  int process(int[][] arr){
        int row=arr.length;
        int col=arr[0].length;
        int[][] dp= new int[row][col];
        dp[row-1][col-1]=arr[row-1][col-1];
        for(int i=row-2;i>=0;i--){
            dp[i][col-1]=arr[i][col-1]+dp[i+1][col-1];
        }

        for(int j=col-2;j>=0;j--){
            dp[row-1][j]=arr[row-1][j]+dp[row-1][j+1];
        }

        for(int i=row-2;i>=0;i--){
            for(int j=col-2;j>=0;j--){
               dp[i][j]=arr[i][j]+Math.min(dp[i][j+1],dp[i+1][j]);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
        System.out.println(process(m));
        System.out.println(process(m,0,0));
    }

}
