package com.dongdong.spring.leetcode;

public class Top98SortColors {

    public void sortColors(int[] nums) {
        int n=nums.length;
        if(n<2){
          return;
        }
        //all in [0,p0)==0
        //all in [p0,i)==i
        //all in (p2,len-1]==2

        int p0=0;
        int i=0;
        int p1=n-1;
        while (i<=p1){
            if(nums[i]==0){
                Utils.swap(nums,i,p0);
                p0++;
                i++;
            }else if(nums[i]==1){
                i++;
            }else {
                Utils.swap(nums,i,p1);
                p1--;
            }
        }
    }
}
