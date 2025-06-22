package com.dongdong.spring.leetcodetop100_3;

import java.util.HashMap;
import java.util.Map;

/**
 * 和為 k 的子数组数量
 */
public class Top10SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int count = 0;
        int pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
