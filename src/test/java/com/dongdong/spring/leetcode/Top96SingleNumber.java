package com.dongdong.spring.leetcode;
/**
 *只出现一次的数字
 */
public class Top96SingleNumber {

    public int singleNumber(int[] nums) {
        int res=0;
      for(int num:nums){
         res^=num;
      }
      return res;
    }
}
