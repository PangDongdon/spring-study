package com.dongdong.spring.leetcodetop100_2;
/**
 *只出現一次的數字
 */
public class Top96SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
