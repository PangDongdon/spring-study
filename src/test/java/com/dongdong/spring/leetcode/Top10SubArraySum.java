package com.dongdong.spring.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 和为k的子数组
 */
public class Top10SubArraySum {

    public static int subArraySum(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }
        int count = 0;
        int pre = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static int subArraySum2(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end >= 0; end--) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
      /*  输入：nums = [1,1,1], k = 2
        输出：2
        示例 2：

        输入：nums = [1,2,3], k = 3
        输出：2*/
        int[] nums1 = {1, 1, 1};
        int[] nums2 = {1, 2, 3};
        System.out.println(subArraySum(nums1, 2));
        System.out.println(subArraySum(nums2, 3));
        System.out.println(subArraySum2(nums1, 2));
        System.out.println(subArraySum2(nums2, 3));
    }
}
