package com.dongdong.spring.leetcodetop100_3;
/**
 *搜索插入位置
 */
public class Top65SearchInsert {
    public int searchInsert(int[] nums, int target) {
       int left = 0;
       int right = nums.length - 1;
       while(left <= right){
           int mid = ((right - left) >> 1) + left;
           if(nums[mid]< target){
               left = mid + 1;
           }else {
               right = mid - 1;
           }
       }
       return left;
    }
}
