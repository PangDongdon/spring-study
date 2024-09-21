package com.dongdong.spring.leetcode;

/**
 *寻找旋转排序数组中的最小值
 */
public class Top67FindMin {
    public int findMin(int[] nums) {
         if(nums==null || nums.length<1){
             return -1;
         }
         int left=0;
         int right=nums.length-1;
         while (left<right){
             int mid=((right-left)>>1)+left;
             if(nums[mid]<nums[right]){
                 right=mid;
             }else {
                 left=mid+1;
             }
         }
         return nums[left];
    }
}
