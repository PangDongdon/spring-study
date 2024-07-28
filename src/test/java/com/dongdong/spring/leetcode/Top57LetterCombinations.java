package com.dongdong.spring.leetcode;


import lombok.val;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *电话号码和数字组合
 */
public class Top57LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        if(digits.length()==0){
            return res;
        }
        Map<Character,String> map=new HashMap();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        backtrace(res,map,digits,0,new StringBuffer());
        return res;
    }

    private void backtrace(List<String> res, Map<Character, String> map, String digits, int index, StringBuffer combination) {
      if(index==digits.length()){
          res.add(combination.toString());
      }
         char c = digits.charAt(index);
         String letter = map.get(c);
         for(int i=0;i<letter.length();i++){
             combination.append(letter.charAt(i));
             backtrace(res, map, digits, index+1, combination);
             combination.deleteCharAt(index);
         }
    }
}
