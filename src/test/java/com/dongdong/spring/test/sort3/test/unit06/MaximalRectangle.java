package com.dongdong.spring.test.sort3.test.unit06;

import java.util.Stack;

public class MaximalRectangle {

    public static int maxRecSize(int[][] map) {
        if (map == null || map.length == 0 || map[0].length == 0) {
            return 0;
        }
        int maxValue = 0;
        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxValue = Math.max(maxValue, maxRecFromBottom(height));
        }
        return maxValue;
    }

    public static int maxRecFromBottom(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxValue = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curRes = (i - k - 1) * height[j];
                maxValue = Math.max(maxValue, curRes);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curRes = (height.length - k - 1) * height[j];
            maxValue = Math.max(maxValue, curRes);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[][] map = {{1, 0, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 0},};
        System.out.println(maxRecSize(map));
    }
}
