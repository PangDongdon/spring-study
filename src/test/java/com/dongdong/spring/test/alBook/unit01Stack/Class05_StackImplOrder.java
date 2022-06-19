package com.dongdong.spring.test.alBook.unit01Stack;

import net.dongliu.commons.Sys;

import java.util.Stack;

/**
 * 用一个栈实现另一个栈排序
 */
public class Class05_StackImplOrder {

    public static  void sortByStack(Stack<Integer> stack){
        Stack<Integer> help=new Stack<>();
        while (!stack.isEmpty()){
            int cur=stack.pop();
            while(!help.isEmpty() && help.peek()<cur){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()){
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(4);
        stack.push(10);
        stack.push(1);
        stack.push(2);
        sortByStack(stack);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

}
