package com.dongdong.spring.leetcode;
/**
 *下一个排列
 */
public class Top99NextPermutation {

    public void nextPermutation(int[] nums) {
      int i=nums.length-2;
      while (i>=0 && nums[i]>=nums[i+1]){
          i--;
      }
     if(i>0){
         int j=nums.length-1;
         while (j>=0 && nums[i]>=nums[j]){
             j--;
         }
         this.swap(nums,i,j);
     }
      reverse(nums,i+1);
    }

    private void reverse(int[] nums, int start) {
        int left=start,right=nums.length-1;
        while (left<right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }

    public  void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
