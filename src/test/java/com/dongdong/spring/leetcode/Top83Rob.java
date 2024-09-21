package com.dongdong.spring.leetcode;

public class Top83Rob {

    public int rob(int[] nums) {
      if(nums==null || nums.length<1){
          return 0;
      }
      int length=nums.length;
      if(length==1){
          return nums[0];
      }
      int[] dp=new int[length];
      dp[0]=nums[0];
      dp[1]=Math.max(nums[1],nums[0]);

      for(int i=2;i<length;i++){
          dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
      }
      return dp[length-1];
    }

    public int rob2(int[] nums) {
        if(nums==null || nums.length<1){
            return 0;
        }
        int length=nums.length;
        if(length==1){
            return nums[0];
        }
        int first=nums[0];
        int second=Math.max(nums[1],nums[0]);
        for(int i=2;i<length;i++){
           int temp=second;
           second=Math.max(first+nums[i],second);
           first=temp;
        }
        return second;
    }


}
