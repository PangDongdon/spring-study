package com.dongdong.spring.test.alBook.unit01Stack;

import java.util.Stack;
//使用递归函数逆序栈
public class Class03_StackReverseStack {

    public static  int getStackLastElement(Stack<Integer> stack){
        int result=stack.pop();
        if(stack.isEmpty()){
            return  result;
        }
        int last=getStackLastElement(stack);
        stack.push(result);
        return last;
    }

    public static  void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int i=getStackLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverse(stack);
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

}
