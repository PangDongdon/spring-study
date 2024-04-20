package com.dongdong.spring.test2.sort.basic_class2;

import java.util.Stack;

public class TwoStackQueue {
    Stack<Integer> popStack;
    Stack<Integer> pushStack;

    public TwoStackQueue() {
        popStack = new Stack<>();
        pushStack = new Stack<>();
    }

    private void push(int pushInt) {
        pushStack.push(pushInt);
        dao();
    }

    private void peek() {
        if (pushStack.isEmpty() && popStack.isEmpty()) {
            throw new IllegalArgumentException("params is empty");
        }
        dao();
        popStack.peek();
    }

    private void poll() {
        if (pushStack.isEmpty() && popStack.isEmpty()) {
            throw new IllegalArgumentException("params is empty");
        }
        dao();
        popStack.pop();
    }

    private void dao() {
        if (pushStack.isEmpty()) {
            while (!popStack.isEmpty()) {
                pushStack.push(popStack.pop());
            }
        }
    }
}
