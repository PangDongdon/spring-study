package com.dongdong.spring.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *括号生成
 */
public class Top59GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
      List<String> ans=new ArrayList<>();
      backtrack(ans,new StringBuilder(),0,0,n);
      return ans;
    }

    private void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if(cur.length()==max*2){
          ans.add(cur.toString());
          return;
        }
        if(open<close){
            cur.append('(');
            backtrack(ans, cur, open+1, close, max);
            cur.deleteCharAt(cur.length()-1);
        }

        if(open>close){
            cur.append(')');
            backtrack(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}
