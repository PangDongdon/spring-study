package com.dongdong.spring.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *电话号码和数字组合
 */
public class Top57LetterCombinations {
    public List<String> letterCombinations2(String digits) {
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
          return;
      }
         char c = digits.charAt(index);
         String letter = map.get(c);
         for(int i=0;i<letter.length();i++){
             combination.append(letter.charAt(i));
             backtrace(res, map, digits, index+1, combination);
             combination.deleteCharAt(index);
         }
    }

    List<String> res=new ArrayList<>();
    StringBuilder stringBuilder=new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if(digits==null){
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
        backTracking(digits,map,0);
        return res;
    }

    private void backTracking(String digits,Map<Character,String> map,int num){
        if(digits.length()==0){
            res.add(stringBuilder.toString());
            return;
        }
       String s = map.get(digits.charAt(num));
        for(int i=0;i<s.length();i++){
            stringBuilder.append(s.charAt(i));
            backTracking(digits, map, num+1);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }

    }

}
