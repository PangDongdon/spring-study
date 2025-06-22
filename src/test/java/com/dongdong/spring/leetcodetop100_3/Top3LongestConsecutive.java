package com.dongdong.spring.leetcodetop100_3;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 */
public class Top3LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longStreak = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longStreak = Math.max(longStreak, currentStreak);
            }
        }
        return longStreak;
    }
}
