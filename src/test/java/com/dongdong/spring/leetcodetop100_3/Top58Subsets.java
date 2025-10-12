package com.dongdong.spring.leetcodetop100_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集
 */
public class Top58Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backtrace(nums,res,path,0);
        return res;
    }

    private void backtrace(int[] nums, List<List<Integer>> res, LinkedList<Integer> path, int index) {
         res.add(new ArrayList<>(path));
         for(int i=index;i<nums.length;i++){
             path.add(nums[i]);
             backtrace(nums,res,path,i+1);
             path.removeLast();
         }
    }
}
