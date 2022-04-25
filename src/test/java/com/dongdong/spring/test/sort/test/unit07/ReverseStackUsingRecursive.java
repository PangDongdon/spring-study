package com.dongdong.spring.test.sort.test.unit07;

import java.util.Stack;

public class ReverseStackUsingRecursive {


    public static int getRemoveLastElement(Stack<Integer> stack) {
            int result = stack.pop();
            if (stack.isEmpty()) {
                return result;
            } else {
               int last= getRemoveLastElement(stack);
               stack.push(result);
               return  last;
            }
    }

    public static void reverse(Stack<Integer> stack) {
        if(stack.isEmpty()){
            return;
        }
        int i=getRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void printStack(Stack<Integer> stack){
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        //原始
       // printStack(stack);
        //逆序
        reverse(stack);
        System.out.println();
        printStack(stack);
    }
}
