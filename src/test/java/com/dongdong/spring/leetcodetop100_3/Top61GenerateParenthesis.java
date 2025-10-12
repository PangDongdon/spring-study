package com.dongdong.spring.leetcodetop100_3;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 */
public class Top61GenerateParenthesis {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backTracking(new StringBuilder(), 0, 0, n);
        return res;
    }

    private void backTracking(StringBuilder stringBuilder, int open, int close, int n) {
        if (stringBuilder.length() == n * 2) {
            res.add(stringBuilder.toString());
            return;
        }
        if (open < n) {
            stringBuilder.append('(');
            backTracking(stringBuilder, open + 1, close, n);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (open > close) {
            stringBuilder.append(')');
            backTracking(stringBuilder, open, close + 1, n);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
