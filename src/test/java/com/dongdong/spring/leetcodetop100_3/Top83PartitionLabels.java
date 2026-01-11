package com.dongdong.spring.leetcodetop100_3;
/**
 * 划分字母区间
 */

import java.util.ArrayList;
import java.util.List;

public class Top83PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] ss = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            ss[s.charAt(i) - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            end = Math.max(end, ss[s.charAt(i) - 'a']);
            if (end == i) {
                ans.add(end - start + 1);
                start = i + 1;
            }
        }
        return ans;
    }
}
