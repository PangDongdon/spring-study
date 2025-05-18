package com.dongdong.spring.leetcodetop100_2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分
 */
public class Top86WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> ss=new HashSet<>(wordDict);
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
               if(dp[j] && ss.contains(s.substring(j,i))) {
                   dp[i]=true;
                   break;
               }
            }
        }
        return dp[s.length()];
    }
}
