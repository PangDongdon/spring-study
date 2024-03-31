package com.dongdong.spring.leetcode;

import org.assertj.core.util.Lists;

import java.util.*;

/**
 * 字母异位词分组
 */
public class Top2groupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        //遍历
        for (String str : strs) {
            //排序，让相同字母组成的字符串，key相同
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortStr = new String(chars);
            List<String> orDefault = map.getOrDefault(sortStr, Lists.newArrayList());
            orDefault.add(str);
            map.put(sortStr, orDefault);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
