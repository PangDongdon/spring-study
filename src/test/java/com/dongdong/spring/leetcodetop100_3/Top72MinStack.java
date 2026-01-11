package com.dongdong.spring.leetcodetop100_3;

import java.util.Stack;

/**
 * 最小栈
 */
public class Top72MinStack {
    private Stack<Node> stack;

    public Top72MinStack() {
        stack = new Stack<>();
    }

    public static class Node {
        private int data;
        private int min;

        public Node(int data, int min) {
            this.data = data;
            this.min = min;
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().data;
    }

    public int getMin() {
        return stack.peek().min;
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new Node(x, x));
        } else {
            stack.push(new Node(x, Math.min(x, stack.peek().min)));
        }
    }
}
