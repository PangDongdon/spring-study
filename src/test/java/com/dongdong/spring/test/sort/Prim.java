package com.dongdong.spring.test.sort;

import org.springframework.security.core.parameters.P;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Prim {

    public static  class EdgeComparator implements Comparator<Edge>{
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight-o2.weight;
        }
    }

    public Set<Edge> primMST(Graph graph){
        PriorityQueue<Edge> priorityQueue=new PriorityQueue<>(new EdgeComparator());
        HashSet<Node> set=new HashSet<>();
        Set<Edge> result=new HashSet<>();
        for(Node node:graph.nodes.values()){
            if(!set.contains(node)){
               set.add(node);
               for(Edge edge:node.edges){
                   priorityQueue.add(edge);
               }
               while(!priorityQueue.isEmpty()){
                  Edge edge= priorityQueue.poll();
                  Node toNode=edge.toNode;
                  if(!set.contains(toNode)){
                      set.add(toNode);
                      result.add(edge);
                      for(Edge edge1:toNode.edges){
                          priorityQueue.add(edge1);
                      }
                  }
               }
            }
        }
        return  result;
    }
}
