package com.dongdong.spring.leetcodetop100_3;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 */
public class Top85Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> a = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    a.add(1);
                } else {
                    a.add(res.get(i - 1).get(j) + res.get(i - 1).get(j - 1));
                }
            }
            res.add(a);
        }
        return res;
    }
}
