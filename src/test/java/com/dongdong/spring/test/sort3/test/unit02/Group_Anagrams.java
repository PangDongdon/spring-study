package com.dongdong.spring.test.sort3.test.unit02;

import org.apache.commons.lang.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group_Anagrams {

    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null) {
            return null;
        }
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> list=new ArrayList<>();
        for (String s : strs) {
            int[] record = new int[26];
            char[] chars = s.toCharArray();
            for (char c : chars) {
                record[c - 'a']++;
            }
            StringBuilder builder = new StringBuilder();
            for (int val : record) {
                builder.append(val).append("_");
            }
            String key = builder.toString();
            if (map.containsKey(key)) {
                map.put(builder.toString(), Lists.newArrayList(s));
            } else {
                map.get(key).add(s);
            }
            for(List<String> s2:map.values()){
                list.add(s2);
            }
        }
        return list;
    }
}
