package com.dongdong.spring.leetcodetop100_3;

/**
 * 跳跃游戏
 */
public class Top80CanJump {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int maxPosition = 0;
        for (int i = 0; i < length; i++) {
            if (i <= maxPosition) {
                maxPosition = Math.max(maxPosition, i + nums[i]);
            }
            if (maxPosition >= length - 1) {
                return true;
            }
        }
        return false;
    }
}
