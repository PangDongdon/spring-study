package com.dongdong.spring.test.sort;

import com.dongdong.spring.test.sort.basic_class_05.Code_05_Kruskal;

import java.util.*;

public class Kruskal {
    //并差集
    public static class UnionFind {
        private HashMap<Node, Node> fatherMap;
        private HashMap<Node, Integer> rankMap;

        public UnionFind() {
            fatherMap = new HashMap<>();
            rankMap = new HashMap();
        }

        public Node findFather(Node n) {
            Node father = fatherMap.get(n);
            if (n != father) {
                father = findFather(father);
            }
            fatherMap.put(n, father);
            return father;
        }

        public void makeSets(Collection<Node> nodes) {
            fatherMap.clear();
            rankMap.clear();
            for (Node node : nodes) {
                fatherMap.put(node, node);
                rankMap.put(node, 1);
            }
        }

        public boolean isSameSet(Node a, Node b) {
            return findFather(a) == findFather(b);
        }

        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            Node aFather = fatherMap.get(a);
            Node bFather = fatherMap.get(b);
            if(aFather!=bFather){
                Integer aRank=rankMap.get(a);
                Integer bRank=rankMap.get(b);
                if(aRank<=bRank){
                    fatherMap.put(aFather,bFather);
                    rankMap.put(bFather,aRank+bRank);
                }else{
                    fatherMap.put(bFather,aFather);
                    rankMap.put(aFather,aRank+bRank);
                }
            }
        }

    }

    public static class EdgeComparator  implements Comparator<Edge>{
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight-o2.weight;
        }
    }

    public Set<Edge>  kruskalMST(Graph graph){
       UnionFind unionFind=new UnionFind();
       unionFind.makeSets(graph.nodes.values());
       PriorityQueue<Edge> priorityQueue=new PriorityQueue<>(new EdgeComparator());
       for(Edge edge:graph.edges){
           priorityQueue.add(edge);
       }
       Set<Edge> result=new HashSet<>();
       while(!priorityQueue.isEmpty()){
           Edge edge=priorityQueue.poll();
           if(!unionFind.isSameSet(edge.fromNode,edge.toNode)){
               result.add(edge);
               unionFind.union(edge.fromNode,edge.toNode);
           }
       }
       return  result;
    }


    public Set<Edge>  kruskalMST2(Graph graph){
        UnionFind unionFind=new UnionFind();
        //初始化数据
        unionFind.makeSets(graph.nodes.values());

        PriorityQueue<Edge> priorityQueue=new PriorityQueue<>(new EdgeComparator());
        for(Edge edge:graph.edges){
             priorityQueue.add(edge);
        }
        Set<Edge> set=new HashSet<>();
        while(!priorityQueue.isEmpty()){
            Edge edge = priorityQueue.poll();
            if(!unionFind.isSameSet(edge.fromNode,edge.toNode)){
                set.add(edge);
                unionFind.union(edge.fromNode,edge.toNode);
            }
        }
        return set;
    }
























}
