package com.dongdong.spring.leetcodetop100_2;

/**
 * 跳跃游戏
 */
public class Top78CanJump {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
            }
            if (rightmost >= n - 1) {
                return true;
            }
        }
        return false;
    }
}
