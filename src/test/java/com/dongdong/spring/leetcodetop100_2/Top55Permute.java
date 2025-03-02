package com.dongdong.spring.leetcodetop100_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *全排列
 */
public class Top55Permute {
    List<List<Integer>> res=new ArrayList<>();
    LinkedList<Integer> path=new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
       if(nums==null || nums.length<1){
           return res;
       }
       used=new boolean[nums.length];
       backtrace(nums);
       return res;
    }

    private void backtrace(int[] nums) {
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
            backtrace(nums);
            path.removeLast();
            used[i]=false;
        }
    }
}
