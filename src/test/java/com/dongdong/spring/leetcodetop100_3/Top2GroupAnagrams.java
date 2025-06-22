package com.dongdong.spring.leetcodetop100_3;

import java.util.*;

/**
 *字母异位词分组
 */
public class Top2GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            final char[] chars = str.toCharArray();
            Arrays.sort(chars);
            if(map.containsKey(new String(chars))){
                map.get(new String(chars)).add(str);
            }else {
                List<String> list=new ArrayList<>();
                list.add(str);
                map.put(new String(chars),list);
            }
        }
        return new ArrayList<>(map.values());
    }
}
