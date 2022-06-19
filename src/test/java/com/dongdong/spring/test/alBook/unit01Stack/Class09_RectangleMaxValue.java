package com.dongdong.spring.test.alBook.unit01Stack;

import net.dongliu.commons.Sys;

import java.util.Stack;

/**
 * 求最大子矩阵的大小
 */
public class Class09_RectangleMaxValue {

    public static int maxRecSize(int[][] map) {
        if (map == null || map[0] == null) {
            return 0;
        }
        int maxValue = 0;
        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxValue = Math.max(maxValue, maxRecFromBottom(height));
        }
        return maxValue;
    }

    public static int maxRecFromBottom(int[] height) {
        if (height == null || height.length < 1) {
            return 0;
        }
        int maxValue = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                int popx = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                maxValue = Math.max(maxValue, (i - left - 1) * height[popx]);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int popx = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
            maxValue = Math.max(maxValue, (height.length - left - 1) * height[popx]);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[][] ss = {{1,0,1,1},{1,1,1,1},{1,1,1,0}};
        System.out.println(maxRecSize(ss));
    }

}
