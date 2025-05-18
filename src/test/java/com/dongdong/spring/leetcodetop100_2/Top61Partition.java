package com.dongdong.spring.leetcodetop100_2;

import java.util.ArrayList;
import java.util.List;

public class Top61Partition {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrcking(s, 0, new StringBuilder());
        return res;
    }

    private void backtrcking(String s, int startIndex, StringBuilder sb) {
        if (startIndex == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (check(sb)) {
                path.add(sb.toString());
                backtrcking(s, i + 1, new StringBuilder());
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean check(StringBuilder sb) {
        int i = 0;
        int j = sb.length() - 1;
        while (i < sb.length() && j > 0 && i <= j) {
            if (sb.charAt(i) != sb.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
