package com.dongdong.spring.test.sort;

//图的边
public class Edge {
    public  int weight;
    public  Node  fromNode;
    public  Node  toNode;

    public  Edge(int weight,Node fromNode,Node toNode){
        this.weight=weight;
        this.fromNode=fromNode;
        this.toNode=toNode;
    }
}
