package com.dongdong.spring.test.sort;

import java.util.Stack;

public class ReverseStackUsingRecursive {

    public static void reverse(Stack<Integer> stack) throws Exception {
        if (stack.isEmpty()) {
            return;
        }
        int result = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(result);
    }


    public static int getAndRemoveLastElement(Stack<Integer> stack) throws Exception {
        if (stack.isEmpty()) {
            throw new Exception("输入参数有误");
        }
        Integer result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        }
        int i = getAndRemoveLastElement(stack);
        stack.push(result);
        return i;
    }


    public static void main(String[] args) throws Exception {
        Stack<Integer> test = new Stack<Integer>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        reverse(test);
        while (!test.isEmpty()) {
            System.out.println(test.pop());
        }
    }
}
