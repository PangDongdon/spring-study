package com.dongdong.spring.test.sort;

//生成图
public class GraphGenerator {

    public Graph generatorGraph(int[][] matrix){
        if(matrix==null){
            return  null;
        }
        Graph graph=new Graph();
        for(int i=0;i<matrix.length;i++){
            int weight=matrix[i][0];
            int from=matrix[i][1];
            int to=matrix[i][2];

            if(!graph.nodes.containsKey(from)){
                graph.nodes.put(from,new Node(from));
            }
            if(!graph.nodes.containsKey(to)){
                graph.nodes.put(to,new Node(to));
            }
           Node fromNode=graph.nodes.get(from);
           Node toNode=graph.nodes.get(to);
           Edge edge=new Edge(weight,fromNode,toNode);
           fromNode.nexts.add(toNode);
           fromNode.out++;
           toNode.in++;
           fromNode.edges.add(edge);
           graph.edges.add(edge);
        }
        return  graph;
    }
}
