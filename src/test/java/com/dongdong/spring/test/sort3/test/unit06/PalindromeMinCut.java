package com.dongdong.spring.test.sort3.test.unit06;

import org.apache.logging.log4j.util.Strings;

public class PalindromeMinCut {

    public static int minCut(String str) {
        if(Strings.isBlank(str)){
            return 0;
        }
        char[] s=str.toCharArray();
        int length=s.length;
        int[] dp=new int[length+1];
        dp[length]=-1;
        boolean[][] p=new boolean[length][length];
        for(int i=length-1;i>-1;i--){
            dp[i]=Integer.MAX_VALUE;
            for(int j=i;j<length;j++){
                if(s[i]==s[j] &&(j-i<2 || p[i+1][j-1])){
                    p[i][j]=true;
                    dp[i]=Math.min(dp[i],dp[j+1]+1);
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        String s="ACCDCDC";
        System.out.println(minCut(s));
    }
}
