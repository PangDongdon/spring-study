package com.dongdong.spring.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *全排列
 */
public class Top55Permute {
    public List<List<Integer>> permute(int[] nums) {
       if(nums==null ||nums.length<1){
           return null;
       }
       List<List<Integer>> res=new ArrayList<>();
       List<Integer> outPut=new ArrayList<>();
       for(int num:nums){
        outPut.add(num);
       }
       int n=nums.length;
       backtrace(n,outPut,res,0);
       return res;
    }

    private void backtrace(int n, List<Integer> outPut, List<List<Integer>> res, int first) {
       //所有的数都填完了
       if(first==n){
          res.add(new ArrayList<>(outPut));
       }
       for(int i=0;i<n;i++){
           //动态维护数组
           Collections.swap(outPut,first,i);
           backtrace(n,outPut,res,first+1);
           //撤销数组
           Collections.swap(outPut,first,i);
       }
    }


    List<List<Integer>> res=new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permute2(int[] nums) {
        if(nums.length==0){
            return res;
        }
        used=new boolean[nums.length];
        backtrace2(nums);
        return res;
    }

    private void backtrace2(int[] nums) {
      if(path.size()==nums.length){
          res.add(new ArrayList<>(path));
          return;
      }
      for(int i=0;i<nums.length;i++){
          if(used[i]){
              continue;
          }
          used[i]=true;
          path.add(nums[i]);
          backtrace2(nums);
          path.removeLast();
          used[i]=false;
      }
    }
}
