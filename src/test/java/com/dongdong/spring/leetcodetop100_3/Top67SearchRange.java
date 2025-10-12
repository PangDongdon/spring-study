package com.dongdong.spring.leetcodetop100_3;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 */
public class Top67SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int leftId = search(nums, target, true);
        int rightId = search(nums, target, false) - 1;
        if (leftId <= rightId && rightId < nums.length && nums[leftId] == target
                && nums[rightId] == target) {
            return new int[]{leftId, rightId};
        }
        return new int[]{-1, -1};
    }

    public int search(int[] nums, int target, boolean isLeft) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] > target || (isLeft && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
