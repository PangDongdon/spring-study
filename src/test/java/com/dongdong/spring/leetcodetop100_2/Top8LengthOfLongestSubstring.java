package com.dongdong.spring.leetcodetop100_2;

import java.util.HashSet;
import java.util.Set;

/**
 *无重复字符的最长子串
 */
public class Top8LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int rk=-1;
        int ans=0;
        int n=s.length();
        Set<Character> set=new HashSet<>();
        for(int i=0;i<n;i++){
            if(i!=0){
               set.remove(s.charAt(i-1));
            }
            while (rk+1<n && !set.contains(s.charAt(rk+1))){
                set.add(s.charAt(rk+1));
                rk++;
            }
            ans=Math.max(ans,rk-i+1);
        }
        return ans;
    }
}
