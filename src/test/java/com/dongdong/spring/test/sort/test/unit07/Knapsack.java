package com.dongdong.spring.test.sort.test.unit07;

public class Knapsack {

    public static  int maxValue(int[] w,int[] v,int bag){
        if(w==null || v==null){
            return 0;
        }
        return process(w,v,0,0,bag);
    }

    public static  int process(int[] w,int[] v,int i,int alreadyWeigh,int bag){
        if(alreadyWeigh>bag){
            return Integer.MIN_VALUE;
        }
        if(i==w.length){
            return 0;
        }
        return Math.max(process(w,v,i+1,alreadyWeigh,bag),v[i]+process(w,v,i+1,alreadyWeigh+w[i],bag));
    }

    public static  int process2(int[] w,int[] v,int bag){
        int[][] dp= new int[w.length+1][bag+1];
        for(int i=0;i<=bag;i++){
            dp[w.length][i]=0;
        }
        for(int i=w.length-1;i>=0;i--){
            for(int j=bag;j>=0;j--){
                dp[i][j]=dp[i+1][j];
                if(j+w[i]<=bag){
                    dp[i][j]=Math.max(dp[i+1][j],v[i]+dp[i+1][j+w[i]]);
                }
            }
        }
        return  dp[0][0];
    }

    public static void main(String[] args) {
        int[] c = { 3, 2, 4, 7 };
        int[] p = { 5, 6, 3, 19 };
        int bag = 11;
        System.out.println(maxValue(c, p, bag));
        System.out.println(process2(c, p, bag));
    }
}
