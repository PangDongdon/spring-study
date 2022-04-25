package com.dongdong.spring.test.sort4;

import java.util.Stack;

//使用递归函数，实现栈的逆序
public class ReverseStack {

    //获取栈底的元素
    public static int getLast(Stack<Integer> stack){
        int res=stack.pop();
        if(stack.isEmpty()){
            return res;
        }
       int last= getLast(stack);
       stack.push(res);
       return last;
    }

    //
    public static  void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int last=getLast(stack);
        reverse(stack);
        stack.push(last);
    }

    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        reverse(stack);
        System.out.println(stack.pop());
    }
}
