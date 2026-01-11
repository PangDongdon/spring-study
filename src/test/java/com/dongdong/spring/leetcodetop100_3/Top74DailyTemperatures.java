package com.dongdong.spring.leetcodetop100_3;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 每日温度
 */
public class Top74DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length < 1) {
            return null;
        }
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }
}
