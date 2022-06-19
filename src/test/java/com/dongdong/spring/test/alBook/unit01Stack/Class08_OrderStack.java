package com.dongdong.spring.test.alBook.unit01Stack;

import com.dongdong.spring.test.alBook.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 单调栈
 */
public class Class08_OrderStack {

    //arr 中的值不重复
    public static int[][] getNearLessNoRepeat(int[] arr) {
        if (arr == null) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        int[][] res = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int popx = stack.pop();
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                res[popx][0] = leftIndex;
                res[popx][1] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int popx = stack.pop();
            int leftIndex = stack.isEmpty() ? -1 : stack.peek();
            res[popx][0] = leftIndex;
            res[popx][1] = -1;
        }
        return res;
    }

    //arr 中的值重复
    public static int[][] getNearLessNoRepeat2(int[] arr) {
        if (arr == null) {
            return null;
        }
        Stack<List<Integer>> stack = new Stack<>();
        int[][] res = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                List<Integer> pops = stack.pop();
                int leftIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                for (Integer popx : pops) {
                    res[popx][0] = leftIndex;
                    res[popx][1] = i;
                }
            }
            //add data
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }
        while (!stack.isEmpty()) {
            List<Integer> pops = stack.pop();
            int leftIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            for (Integer popx : pops) {
                res[popx][0] = leftIndex;
                res[popx][1] = -1;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] ss = {3, 4, 1, 5, 6, 2, 7};
        int[] ss2= {3, 1, 3, 4, 3, 5, 3,2,2};
        int[][] res = getNearLessNoRepeat2(ss2);
        Utils.printData(res);
    }
}
