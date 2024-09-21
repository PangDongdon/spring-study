package com.dongdong.spring.leetcode;

import java.util.Stack;

public class Top70MinStack {

   private Stack<Node> stack;

    public Top70MinStack() {
      stack=new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new Node(val,val));
        }else {
            stack.push(new Node(val,Math.min(stack.peek().min,val)));
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

    private static class Node{
        private int data;
        private int min;

        public Node(int data,int min){
            this.data=data;
            this.min=min;
        }
    }
}
