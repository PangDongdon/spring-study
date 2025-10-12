package com.dongdong.spring.leetcodetop100_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和
 */
public class Top60CombinationSum {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //排序
        Arrays.sort(candidates);
        int sum = 0;
        backtrace(candidates, sum, target, 0);
        return res;
    }

    private void backtrace(int[] candidates, int sum, int target, int index) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            sum += candidates[i];
            path.add(candidates[i]);
            backtrace(candidates, sum, target, i);
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
