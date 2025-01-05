package com.dongdong.spring.leetcodetop100_2;

public class Top4MoveZeroes {

    public void moveZeroes(int[] nums) {
        int  n=nums.length;
        int  right=0;
        int  left=0;
        while (right<n){
            if(nums[right]!=0){
                Util.swap(nums,right,left);
                left++;
            }
            right++;
        }
    }
}
