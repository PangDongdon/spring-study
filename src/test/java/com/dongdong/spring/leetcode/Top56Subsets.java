package com.dongdong.spring.leetcode;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
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

    List<List<Integer>> res=new ArrayList<>();
    LinkedList<Integer> path=new LinkedList<>();
    public List<List<Integer>> subsets2(int[] nums) {
        if(nums.length==0){
            return res;
        }
       backtrack(nums,0);
        return res;
    }

    private void backtrack(int[] nums,int startIndex) {
        res.add(new ArrayList<>(path));
           if(startIndex>=nums.length){
               return;
           }
        for(int i=startIndex;i<nums.length;i++){
            path.add(nums[i]);
            backtrack(nums,i+1);
            path.removeLast();
        }
    }

}
