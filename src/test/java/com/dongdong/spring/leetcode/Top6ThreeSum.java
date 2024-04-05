package com.dongdong.spring.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 */
public class Top6ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = n - 1;
            int target = -nums[first];
            for (int second = first + 1; second < n; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }

                if (third == second) {
                    break;
                }

                if (target == nums[second] + nums[third]) {
                    List<Integer> an = new ArrayList<>();
                    an.add(nums[first]);
                    an.add(nums[second]);
                    an.add(nums[third]);
                    ans.add(an);
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 2, 3};
        int[] nums2 = {0, 0, 0, 0};
        System.out.println(threeSum(nums2));
    }
}
