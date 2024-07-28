package com.dongdong.spring.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和
 */
public class Top58CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int index) {
        if (index == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        //
        dfs(candidates, target, ans, combine, index + 1);
        //选择当前数
        if (target - candidates[index] >= 0) {
            combine.add(candidates[index]);
            dfs(candidates, target - candidates[index], ans, combine, index);
            combine.remove(combine.size() - 1);
        }
    }
}
