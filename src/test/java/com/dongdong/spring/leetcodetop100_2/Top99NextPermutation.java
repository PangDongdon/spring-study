package com.dongdong.spring.leetcodetop100_2;

public class Top99NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(i + 1, nums);
    }

    private void reverse(int i, int[] nums) {
        int left = i;
        int right = nums.length - 1;
        while (left<right){
            swap(nums,left++,right--);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
