package com.dongdong.spring.leetcodetop100_3;

/**
 * 爬楼梯
 */
public class Top84ClimbStairs {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 2; i < n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
