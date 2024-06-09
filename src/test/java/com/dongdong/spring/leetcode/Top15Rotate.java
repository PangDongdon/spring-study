package com.dongdong.spring.leetcode;

import com.dongdong.spring.test.sort.test.util.Utils;

/**
 * 轮转数组
 */
public class Top15Rotate {

    public static void rotate(int[] nums, int k) {
        if (nums == null || k < 0) {
            return;
        }
        int length = nums.length;
        k %= length;
        //左部分逆序
        reverse(nums, 0, length - k - 1);
        //右部分逆序
        reverse(nums, length - k, length - 1);
        //整体逆序
        reverse(nums, 0, length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        //给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
        //示例 1:
        //
        //输入: nums = [1,2,3,4,5,6,7], k = 3
        //输出: [5,6,7,1,2,3,4]
        //解释:
        //向右轮转 1 步: [7,1,2,3,4,5,6]
        //向右轮转 2 步: [6,7,1,2,3,4,5]
        //向右轮转 3 步: [5,6,7,1,2,3,4]
        //示例 2:
        //
        //输入：nums = [-1,-100,3,99], k = 2
        //输出：[3,99,-1,-100]
        //解释:
        //向右轮转 1 步: [99,-1,-100,3]
        //向右轮转 2 步: [3,99,-1,-100]
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
        Utils.printArr(nums);
    }
}
