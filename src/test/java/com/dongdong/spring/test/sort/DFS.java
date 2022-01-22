package com.dongdong.spring.test.sort;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DFS {


    public  static  void  dfs(Node node){
        if(node==null){
            return;
        }
        //定义一个栈一个set
        Stack<Node> stack=new Stack<>();
        Set<Node> set=new HashSet<>();
        stack.push(node);
        set.add(node);
        System.out.println(node.value);
        while(!stack.isEmpty()){
           Node cur= stack.pop();
            for(Node next:cur.nexts){
                if(!set.contains(next)){
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}
