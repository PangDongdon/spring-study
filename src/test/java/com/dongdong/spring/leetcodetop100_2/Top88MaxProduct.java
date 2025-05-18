package com.dongdong.spring.leetcodetop100_2;

/**
 * 乘积最大子数组
 */
public class Top88MaxProduct {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        long[] maxF = new long[nums.length];
        long[] minF = new long[nums.length];
        for (int i = 0; i < n; i++) {
            maxF[i] = nums[i];
            minF[i] = nums[i];
        }
        for (int i = 1; i < n; i++) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(minF[i - 1] * nums[i], nums[i]));
            minF[i] = Math.min(maxF[i - 1] * nums[i], Math.min(minF[i - 1] * nums[i], nums[i]));
            if (minF[i] < -1 << 31) {
                minF[i] = nums[i];
            }
        }
        int ans = (int) maxF[0];
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, (int) maxF[i]);
        }
        return ans;
    }
}
