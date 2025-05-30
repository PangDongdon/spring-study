package com.dongdong.spring.leetcodetop100_2;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 */
public class Top82Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> s = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    s.add(1);
                } else {
                    s.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(s);
        }
        return res;
    }
}
