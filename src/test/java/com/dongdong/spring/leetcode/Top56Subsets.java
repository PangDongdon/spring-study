package com.dongdong.spring.leetcode;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 *子集
 */
public class Top56Subsets {
    public List<List<Integer>> subsets(int[] nums) {
       return recurse(nums.length,nums);
    }

    private List<List<Integer>> recurse(int length, int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(length==0){
            res.add(new ArrayList<>());
            return res;
        }
        List<List<Integer>> existing_result= recurse(length-1,nums);
        res.addAll(existing_result);
         for(List<Integer> list:existing_result){
             List<Integer> newSubSet=new ArrayList<>(list);
             newSubSet.add(nums[length-1]);
             res.add(newSubSet);
         }
         return res;
    }
}
