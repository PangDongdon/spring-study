package com.dongdong.spring.leetcodetop100_2;

import com.dongdong.spring.test2.sort.basic_class2.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 每日温度
 */
public class Top72DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length < 1) {
            return null;
        }
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }
}
