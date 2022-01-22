package com.dongdong.spring.test.sort;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {


    public static void  bfs(Node node){
        if(node==null){
            return;
        }
        //
        Queue<Node> queue=new LinkedList<>();
        HashSet set=new HashSet();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()){
           Node cur=queue.poll();
           System.out.println(cur.value+" ");
           for(Node node1:cur.nexts){
               if(!set.contains(node1)){
                   set.add(node1);
                   queue.add(node1);
               }
           }
        }
    }
}
