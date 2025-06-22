package com.dongdong.spring.leetcodetop100_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 */
public class Top9FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        List<Integer> ans = new ArrayList<>();
        if (sLen < pLen) {
            return ans;
        }
        int[] sArr = new int[26];
        int[] pArr = new int[26];
        for (int i = 0; i < pLen; i++) {
            ++sArr[s.charAt(i) - 'a'];
            ++pArr[p.charAt(i) - 'a'];
        }
        if (Arrays.equals(sArr, pArr)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; i++) {
            --sArr[s.charAt(i) - 'a'];
            ++sArr[s.charAt(i + pLen) - 'a'];
            if (Arrays.equals(sArr, pArr)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
