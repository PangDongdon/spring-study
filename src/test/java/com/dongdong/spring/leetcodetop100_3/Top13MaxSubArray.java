package com.dongdong.spring.leetcodetop100_3;

/**
 * 最大子数组和
 */
public class Top13MaxSubArray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (res[i - 1] > 0) {
                res[i] = nums[i] + res[i - 1];
            } else {
                res[i] = nums[i];
            }
            max = Math.max(max, res[i]);
        }
        return max;
    }
}
