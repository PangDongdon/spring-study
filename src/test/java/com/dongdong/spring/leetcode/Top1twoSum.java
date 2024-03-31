package com.dongdong.spring.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 */
public class Top1twoSum {
    public static void main(String[] args) {
        int[] s = {3, 3};
        int[] ints = twoSum(s, 6);
        for (int d : ints) {
            System.out.println(d);
        }
    }

    //[1,2,3]
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (int num : nums) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(num, i++);
        }
        return new int[]{};
    }
}
