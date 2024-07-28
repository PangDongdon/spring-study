package com.dongdong.spring.leetcode;

import java.util.ArrayList;
import java.util.Collections;
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
}
