package com.dongdong.spring.test.alBook.unit01Stack;

import java.util.Stack;

/**
 * 两个栈组成一个队列
 */
public class Class02_TwoStackGenerateQueue {

    private Stack<Integer> stackPop = new Stack<>();
    private Stack<Integer> stackPush = new Stack<>();

    public void pushToPop() {
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void add(int num) {
        stackPush.push(num);
        pushToPop();
    }

    public int poll() throws Exception {
        if (stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new Exception("Queue is empty");
        }
        pushToPop();
        return stackPop.pop();
    }

    public int peek() throws Exception {
        if (stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new Exception("Queue is empty");
        }
        pushToPop();
        return stackPop.peek();
    }
}

