package com.dongdong.spring.leetcodetop100_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Top57LetterCombinations {
    List<String> res=new ArrayList<>();
    StringBuffer s=new StringBuffer();
    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()<1){
            return res;
        }
        Map<Character,String> map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        backtrace(digits,map,0);
        return res;
    }

    private void backtrace(String digits, Map<Character, String> map, int index) {
        if(digits.length()==index){
            res.add(s.toString());
        }
        String ss = map.get(digits.charAt(index));
        for(int i=0;i<ss.length();i++){
            s.append(ss.charAt(i));
            backtrace(digits, map, index+1);
            s.deleteCharAt(s.length()-1);
        }
    }
}
