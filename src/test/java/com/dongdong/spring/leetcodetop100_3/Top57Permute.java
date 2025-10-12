package com.dongdong.spring.leetcodetop100_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 */
public class Top57Permute {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length < 1) {
            return res;
        }
        boolean[] used = new boolean[nums.length];
        backtrace(nums, used);
        return res;
    }

    public void backtrace(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backtrace(nums, used);
            path.removeLast();
            used[i] = false;
        }
    }

}
