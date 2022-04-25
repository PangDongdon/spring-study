package com.dongdong.spring.test.sort.test.unit07;

public class Money_Problem {

    private static boolean money(int[] arr,int aim){
        return  process1(arr,0,0,aim);
    }
    private static  boolean process1(int[] arr,int i,int sum,int aim){
        if(i==arr.length){
            return sum==aim;
        }
        return  process1(arr, i+1, sum, aim) || process1(arr, i+1, sum+arr[i], aim);
    }

    private static  boolean process2(int[] arr,int aim){
        boolean[][] dp=new boolean[arr.length+1][aim+1];
        for(int i=0;i<dp.length;i++){
            dp[i][aim]=true;
        }
        for(int i=arr.length-1;i>=0;i--){
            for(int j=aim-1;j>=0;j--){
                dp[i][j]=dp[i+1][j];
                if(j+arr[i]<=aim){
                    dp[i][j]=dp[i][j] || dp[i+1][j+arr[i]];
                }
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args) {
        int[] arr = { 1, 4, 8 };
        int aim = 14;
        System.out.println(money(arr, aim));
        System.out.println(process2(arr, aim));
    }
}
