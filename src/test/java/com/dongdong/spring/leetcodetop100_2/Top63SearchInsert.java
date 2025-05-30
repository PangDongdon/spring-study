package com.dongdong.spring.leetcodetop100_2;

public class Top63SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
       int[] nums = {1,3,5,6};
       int target = 7;
       int res=searchInsert(nums,target);
    }
}
