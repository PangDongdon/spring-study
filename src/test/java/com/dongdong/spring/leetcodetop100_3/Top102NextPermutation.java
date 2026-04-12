package com.dongdong.spring.leetcodetop100_3;

import static com.dongdong.spring.leetcodetop100_3.Util.swap;

/**
 * 下一个排列
 */
public class Top102NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //从后往前找到第一个升序的数
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            //从后往前找到第一个比i位置数大的数
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        //将i位置后面的数反转
        reverse(i + 1, nums);
    }

    private void reverse(int i, int[] nums) {
        int left = i;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left++, right--);
        }
    }


    private  void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
