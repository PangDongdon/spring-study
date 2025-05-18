package com.dongdong.spring.leetcodetop100_2;

import java.util.ArrayList;
import java.util.List;

/**
 *括号生成
 */
public class Top59GenerateParenthesis {
    List<String> res=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
      backTracking(new StringBuilder(),0,0,n);
      return res;
    }

    private void backTracking(StringBuilder stringBuilder, int open, int close, int max) {
     if(stringBuilder.length()==max*2){
         res.add(stringBuilder.toString());
         return;
     }
     if(open<max){
         stringBuilder.append('(');
         backTracking(stringBuilder, open+1, close, max);
         stringBuilder.deleteCharAt(stringBuilder.length()-1);
     }

     if(open>close){
         stringBuilder.append(')');
         backTracking(stringBuilder, open, close+1, max);
         stringBuilder.deleteCharAt(stringBuilder.length()-1);
     }
    }
}
