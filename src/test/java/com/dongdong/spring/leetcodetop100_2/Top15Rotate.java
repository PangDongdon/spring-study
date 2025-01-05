package com.dongdong.spring.leetcodetop100_2;
/**
 *轮转数组
 */
public class Top15Rotate {

    public void rotate(int[] nums, int k) {
          int n=nums.length;
          k%=n;
          reverse(nums,0,n);
          reverse(nums,0,k);
          reverse(nums,k,n);
    }

    private void reverse(int[] nums,int start,int end){
       while (start<end){
           int temp=nums[start];
           nums[start]=nums[end];
           nums[end]=temp;
           ++start;
           --end;
       }
    }
}
