package com.dongdong.spring.test.sort2;


import java.util.LinkedList;
import java.util.Queue;

/**
 *  队列--》栈  两个队列实现栈的功能
 */
public class Queue_Stack {
    private Queue<Integer> data;
    private Queue<Integer> help;

    public Queue_Stack(){
        this.data=new LinkedList<>();
        this.help=new LinkedList<>();
    }

    public void push(int num){
        data.add(num);
    }

    public int pop(){
        if(data.isEmpty()){
            throw  new RuntimeException("队列为空");
        }
        if(data.size()>1){
            help.add(data.poll());
        }
        int res=data.poll();
        swap();
        return  res;
    }

    public int peek(){
        if(data.isEmpty()){
            throw  new RuntimeException("队列为空");
        }
        if(data.size()>1){
            help.add(data.poll());
        }
        int res=data.poll();
        help.add(res);
        swap();
        return  res;

    }

    private void swap(){
        Queue<Integer> tmp=help;
        help=data;
        data=tmp;
    }
}
