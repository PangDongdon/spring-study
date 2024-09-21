package com.dongdong.spring.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *柱状图中最大的矩形
 **/
public class Top73LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
           int n=heights.length;
           int[] left=new int[n];
           int[] right=new int[n];
        Deque<Integer> stack=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while (!stack.isEmpty() && heights[stack.peek()]>heights[i]){
                stack.pop();
            }
            left[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        stack.clear();

        for(int i=n-1;i>=0;i--){
            while (!stack.isEmpty() && heights[stack.peek()]>heights[i]){
                stack.pop();
            }
            right[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,(right[i]-left[i]-1)*heights[i]);
        }
        return ans;
    }
}
