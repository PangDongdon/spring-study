package com.dongdong.spring.leetcode;
/**
 *最长公共序列
 */
public class Top94LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
           if(text1==null || "".equals(text1) || text2==null || "".equals(text2)){
               return 0;
           }
           int m=text1.length();
           int n=text2.length();
           int[][] dp=new int[m+1][n+1];
           for(int i=1;i<m;i++){
               char a=text1.charAt(i-1);
               for(int j=1;j<n;j++){
                   char b=text2.charAt(j-1);
                   if(a==b){
                       dp[i][j]=dp[i-1][j-1]+1;
                   }else {
                       dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                   }
               }
           }
           return dp[m][n];
    }
}
