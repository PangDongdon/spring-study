package com.dongdong.spring.leetcodetop100_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合问题
 */
public class Top58CombinationSum {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //排序
        Arrays.sort(candidates);
        int sum = 0;
        backTracing(candidates, target, sum, 0);
        return res;
    }

    private void backTracing(int[] candidates, int target, int sum, int index) {
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
            backTracing(candidates, target, sum, i);
            sum -= candidates[i];
            path.removeLast();
        }
    }

}
