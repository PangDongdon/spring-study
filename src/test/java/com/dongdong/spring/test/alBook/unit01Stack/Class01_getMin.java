package com.dongdong.spring.test.alBook.unit01Stack;

import java.util.Stack;
//一个有getMin功能的栈
public class Class01_getMin {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public int getMin() throws Exception {
        if (minStack.isEmpty()) {
            throw new Exception("minStack is empty");
        }
        return minStack.peek();
    }

    public int pop() throws Exception {
        if (stack.isEmpty() || minStack.isEmpty()) {
            throw new Exception("stack is empty");
        }
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
            return stack.pop();
        }
        return stack.pop();
    }

    public void push(int newNum) {
        if (minStack.isEmpty() || minStack.peek() >= newNum) {
            minStack.push(newNum);
        }
        stack.push(newNum);
    }
}
