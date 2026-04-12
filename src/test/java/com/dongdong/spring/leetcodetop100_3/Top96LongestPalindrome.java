package com.dongdong.spring.leetcodetop100_3;
/**
 *最长回文子串
 */
public class Top96LongestPalindrome {
    public String longestPalindrome(String s) {
        int n=s.length();
        if(n<2){
            return s;
        }
        boolean[][] dp=new boolean[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }
        int max=1;
        int begin=0;
        char[] chars=s.toCharArray();
        for(int j=1;j<n;j++){
            for(int i=0;i<j;i++){
                if(chars[i]!=chars[j]){
                    dp[i][j]=false;
                }else {
                    if(j-i<3){
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                if(dp[i][j] && j-i+1>max){
                    max=j-i+1;
                    begin=i;
                }
            }
        }
        return s.substring(begin,begin+max);
    }
}
