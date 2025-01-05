package com.dongdong.spring.leetcodetop100_2;

import lombok.val;

import java.util.*;

public class Top2GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
             char[] chars = str.toCharArray();
             Arrays.sort(chars);
             String s = new String(chars);
             List<String> orDefault = map.getOrDefault(s, new ArrayList<>());
             orDefault.add(str);
             map.put(s,orDefault);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
