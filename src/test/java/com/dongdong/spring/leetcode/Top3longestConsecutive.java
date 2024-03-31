package com.dongdong.spring.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最长连续序列
 */
public class Top3longestConsecutive {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(nums2));
        int[] nums3 = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
        //-1,0
        System.out.println(longestConsecutive(nums3));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        //数据初始化
        for (int num : nums) {
            map.put(num, 1);
        }

        //计数
        for (int num : map.keySet()) {
            if (map.containsKey(num - 1)) {
                count++;
            }
        }
        return count + 1;
    }

    public static int longestConsecutive2(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }
        int longestStreak = 0;
        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum+1)){
                    currentNum+=1;
                    currentStreak+=1;
                }
                longestStreak=Math.max(currentStreak,longestStreak);
            }
        }
        return longestStreak;
    }
}
