package com.dongdong.spring.leetcode;

public class Top4moveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes2(nums);
        PrintArray.printArrayElement(nums);
    }


    /**
     * 示例 1:
     * <p>
     * 输入: nums = [0,1,0,3,12]
     * 1,0,0,3,12
     * 1,3,0,0,12
     * <p>
     * 输出: [1,3,12,0,0]
     * 示例 2:
     * <p>
     * 输入: nums = [0]
     * 输出: [0]
     */
    //移动零
    public static void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int j = 0;
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    //移动零(快排思想)
    public static void moveZeroes2(int[] nums) {
        if (nums == null) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }

}
