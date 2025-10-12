package com.dongdong.spring.leetcodetop100_3;

/**
 * 搜索旋转排序数组的最小元素
 */
public class Top69FindMin {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
