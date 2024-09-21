package com.dongdong.spring.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 *每日温度
 */
public class Top72DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
       if(temperatures==null || temperatures.length<1){
           return null;
       }
        Deque<Integer> stack=new ArrayDeque<>();
        int[] res=new int[temperatures.length];
        for(int i=0; i<temperatures.length;i++){
          while (!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]){
              int index=stack.pop();
              res[index]=i-index;
          }
          stack.push(i);
        }
        return res;
    }
}
