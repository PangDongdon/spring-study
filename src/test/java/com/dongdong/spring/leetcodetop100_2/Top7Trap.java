package com.dongdong.spring.leetcodetop100_2;

public class Top7Trap {
    public int trap(int[] height) {
       int left=0;
       int right=height.length-1;
       int leftMax=0;
       int rightMax=0;
       int ans=0;
       while (left<right){
           leftMax=Math.max(leftMax,height[left]);
           rightMax=Math.max(rightMax,height[right]);
           if(leftMax<rightMax){
               ans+=leftMax-height[left];
               left++;
           }else {
               ans+=rightMax-height[right];
               right--;
           }
       }
       return ans;
    }
}
