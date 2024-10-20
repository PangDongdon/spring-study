package com.dongdong.spring.leetcode;

/**
 * 最长回文子串
 */
public class Top93LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s == null || "".equals(s) || s.length() < 2) {
            return s;
        }
        int len = s.length();
        int max = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        char[] chars=s.toCharArray();
        //長度為1的都是回文
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int L=2;L<=len;L++){
            for(int i=0;i<len;i++){
                //右边界，j-i+1=L
                int j=L+i-1;
                if(j>=len){
                  break;
                }
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
