package com.dongdong.spring.leetcodetop100_2;

/**
 * 搜索旋转排序数组
 */
public class Top66Search {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target <nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
