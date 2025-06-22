package com.dongdong.spring.leetcodetop100_2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Top3LongestConsecutive {
    public static int longestConsecutive(int[] nums) {
        if(nums==null || nums.length<1){
            return 0;
        }
        Set<Integer> set =new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int longStreak=0;
        for(int key:set){
          if(!set.contains(key-1)){
              int currentNum=key;
              int currentStreak=1;
              while (set.contains(currentNum+1)){
                  currentNum+=1;
                  currentStreak+=1;
              }
              longStreak=Math.max(longStreak,currentStreak);
          }
        }
        return longStreak;
    }

    public static void main(String[] args) {
        int[] array={6,5,4,3};
        System.out.println(longestConsecutive(array));
    }
}
