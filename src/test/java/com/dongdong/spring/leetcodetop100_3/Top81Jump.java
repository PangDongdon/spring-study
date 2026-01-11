package com.dongdong.spring.leetcodetop100_3;
/**
 *跳跃游戏II
 */
public class Top81Jump {
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int step = 0;
        for(int i = 0; i < length - 1; i++){
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if(i == end){
                end = maxPosition;
                step++;
            }
        }
        return step;
    }
}
