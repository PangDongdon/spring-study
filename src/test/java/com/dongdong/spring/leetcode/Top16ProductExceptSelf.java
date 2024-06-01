package com.dongdong.spring.leetcode;

import com.dongdong.spring.test.sort.test.util.Utils;

/**
 * 除自身以外数组的乘积
 */
public class Top16ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 1) {
            return nums;
        }
        int[] resArr = new int[nums.length];
        int res = 1;
        //数前积
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                resArr[i] = res;
                continue;
            }
            res *= nums[i - 1];
            resArr[i] = res;
        }

        //数后积
        res = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if(i==nums.length-1){
              continue;
            }
            res *= nums[i + 1];
            resArr[i] *= res;
        }
        return resArr;
    }

    public static void main(String[] args) {
        //给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
        //
        //题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
        //
        //请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
        //
        //
        //
        //示例 1:
        //
        //输入: nums = [1,2,3,4]
        //输出: [24,12,8,6]
        //示例 2:
        //
        //输入: nums = [-1,1,0,-3,3]
        //输出: [0,0,9,0,0]
        int[] nums = {1, 2, 3, 4};
        Utils.printArr(productExceptSelf(nums));
        int[] nums2 = {-1,1,0,-3,3};
        Utils.printArr(productExceptSelf(nums2));
    }
}
