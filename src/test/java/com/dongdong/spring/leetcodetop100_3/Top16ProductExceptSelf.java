package com.dongdong.spring.leetcodetop100_3;

/**
 * 除自身以外数组的乘积
 */
public class Top16ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] resArr = new int[nums.length];
        resArr[0] = 1;
        //数前积
        for (int i = 1; i < nums.length; i++) {
            resArr[i] = resArr[i - 1] * nums[i - 1];
        }
        //数后积
        int res = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            resArr[i] = resArr[i] * res;
            res *= nums[i];
        }
        return resArr;
    }
}
