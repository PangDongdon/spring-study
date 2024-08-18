package com.dongdong.spring.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *分割回文串
 */
public class Top61Partition {
    int[][] f;
    List<List<String>> ret=new ArrayList<>();
    List<String> ans=new ArrayList<>();
    int n;
    public List<List<String>> partition(String s) {
     if(s==null || s.length()<1){
         return null;
     }
     n=s.length();
     f=new int[n][n];
     dfs(s,0);
     return ret;
    }

    private void dfs(String s, int i) {
        if(i==n){
            ret.add(new ArrayList<>(ans));
            return;
        }
        for(int j=i;j<n;++j){
            if(isPalindrome(s,i,j)==1){
                ans.add(s.substring(i,j+1));
                dfs(s,j+1);
                ans.remove(ans.size()-1);
            }
        }
    }

    //记忆化搜索中，f[i][j]=0表示未搜索，1表示回文，-1表示不是回文串
    public int isPalindrome(String s ,int i,int j){
        if(f[i][j]!=0){
            return f[i][j];
        }
        if(i>=j){
            f[i][j]=1;
        }else if(s.charAt(i)==s.charAt(j)){
            f[i][j]=isPalindrome(s,i+1,j-1);
        }else{
            f[i][j]=-1;
        }
        return f[i][j];
    }

    public List<List<String>> partition2(String s) {
        backTracking(s,0,new StringBuilder());
        return ret;
    }

    private void backTracking(String s, int startIndex,StringBuilder sb) {
        if(s.length()==startIndex){
          ret.add(new ArrayList<>(ans));
          return;
        }
        for(int i=startIndex;i<s.length();i++){
            sb.append(s.charAt(i));
            if(check(sb)){
                ans.add(sb.toString());
                backTracking(s,i+1,new StringBuilder());
                ans.remove(ans.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s){
           int i=0;
           int j=s.length()-1;
           while (i<s.length() && j>0 && i<=j){
               if(s.charAt(i)!=s.charAt(j)){
                   return false;
               }
               i++;
               j--;
           }
           return true;
    }

    //helper method, 检查是否是回文
    private boolean check(StringBuilder sb){
        for (int i = 0; i < sb.length()/ 2; i++){
            if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i)){return false;}
        }
        return true;
    }
}
