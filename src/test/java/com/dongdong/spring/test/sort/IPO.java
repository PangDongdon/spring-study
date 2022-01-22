package com.dongdong.spring.test.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {

    public static class Node {
        private int c;
        private int p;

        public Node(int c, int p) {
            this.p = p;
            this.c = c;
        }
    }

    public static class MinCostComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }
    }

    public static class MaxProfitComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }
    }

    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        Node[] nodes = new Node[Profits.length];
        //初始化利润成本数据
        for (int i = 0; i < Profits.length; i++) {
            nodes[i] = new Node(Capital[i], Profits[i]);
        }
        PriorityQueue<Node> minCosts = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfits = new PriorityQueue<>(new MaxProfitComparator());
        //初始化小堆
        for (int i = 0; i < nodes.length; i++) {
            minCosts.add(nodes[i]);
        }

        for (int i = 0; i < k; i++) {
          //挑选成本小堆最小成本并加入利益的大堆中
          while(!minCosts.isEmpty() && minCosts.peek().c<=W){
               maxProfits.add(minCosts.poll());
          }
          //计算利润
          if(maxProfits.isEmpty()){
              return W;
          }
          W+=maxProfits.poll().p;
        }
        return W;
    }


}
