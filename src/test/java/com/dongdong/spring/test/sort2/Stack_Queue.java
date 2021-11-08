package com.dongdong.spring.test.sort2;

import java.util.Stack;

public class Stack_Queue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public Stack_Queue(){
        this.stackPop=new Stack<>();
        this.stackPush=new Stack<>();
    }

     public void push(int num){
        stackPush.push(num);
        goTo();
     }
     public  int pop(){
       if(stackPush.empty() && stackPop.empty()){
           throw  new RuntimeException("");
       }
       goTo();
       return stackPop.pop();
     }

     public int   peek(){
         if(stackPush.empty() && stackPop.empty()){
             throw  new RuntimeException("");
         }
         goTo();
         return stackPop.peek();
     }



    private void goTo(){
        if(stackPop.empty()){
            while(!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
    }

}
