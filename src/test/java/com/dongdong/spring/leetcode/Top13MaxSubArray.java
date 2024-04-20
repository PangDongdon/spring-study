package com.dongdong.spring.leetcode;

/**
 * 最大子数组和
 */
public class Top13MaxSubArray {
    public static int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && sum + nums[i] < 0) {
                sum = 0;
                max = Math.max(max, nums[i]);
                continue;
            }
            sum += nums[i];
            max = Math.max(max, sum);
        }
        return max;
    }


    public static int maxSubArray2(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        //输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
        //输出：6
        //解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
        //示例 2：
        //
        //输入：nums = [1]
        //输出：1
        //示例 3：
        //
        //输入：nums = [5,4,-1,7,8]
        //输出：23
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = {1};
        int[] nums3 = {5, 4, -1, 7, 8};
        int[] nums4 = {-2, 1};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray(nums2));
        System.out.println(maxSubArray(nums3));
        System.out.println(maxSubArray(nums4));

        System.out.println(maxSubArray2(nums));
        System.out.println(maxSubArray2(nums2));
        System.out.println(maxSubArray2(nums3));
        System.out.println(maxSubArray(nums4));
    }
}
