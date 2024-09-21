package com.dongdong.spring.leetcode;

/**
 * 爬楼梯
 */
public class Top81ClimbStairs {
    public int climbStairs(int n) {
        int p = 0;
        int q = 0;
        int r = 1;
        for (int i = 1; i <= n; i++) {//p q r
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    /*private int f(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return f(n - 1) + f(n - 2);
    }*/
}
