package com.dongdong.spring.test.sort3.test.unit05;

import net.dongliu.commons.Sys;

public class Max_Damage {

    public static int getMax(int[] arr) {
        if (arr == null) {
            return 0;
        }
        return process(arr, 0, 10);
    }

    private static int process(int[] arr, int index, int sum) {
        if (sum < 0) {
            return -1;
        }
        if (index == arr.length) {
            return sum == 0 ? 1 : -1;
        }
        int notIncludeCurrent = process(arr, index + 1, sum);
        int includeCurrent = arr[index] * process(arr, index + 1, sum - arr[index]);
        return Math.max(notIncludeCurrent, includeCurrent);
    }

    public static  int getMax(int[] arr,int threshold){
        if(arr==null || arr.length==0){
            return  0;
        }
        int[][] dp=new int[arr.length][threshold+1];
        if(arr[0]<threshold){
            dp[0][arr[0]]=arr[0];
        }
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<=threshold;j++){
               int no=dp[i-1][j];
               int only=j-arr[i]==0?arr[i]:0;
               int part=j-arr[i]>0? dp[i-1][j-arr[i]]*arr[i]:0;
               dp[i][j]=Math.max(no,Math.max(only,part));
            }
        }
        return  dp[dp.length-1][dp[0].length-1];
    }


    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        System.out.println(getMax(arr));
    }
}
