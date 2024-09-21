package com.dongdong.spring.leetcode;

/**
 * 跳跃游戏II
 */
public class Top79Jump {

    public int jump(int[] nums) {
        int length = nums.length;
        int maxPosition = 0;
        int end = 0;
        int step = 0;
        for (int i = 0; i < length-1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                step++;
            }
        }
        return step;
    }
}
