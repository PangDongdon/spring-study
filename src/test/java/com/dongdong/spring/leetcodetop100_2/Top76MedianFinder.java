package com.dongdong.spring.leetcodetop100_2;

import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 */
public class Top76MedianFinder {
    PriorityQueue<Integer> queueMin;
    PriorityQueue<Integer> queueMax;

    public Top76MedianFinder() {
        queueMax = new PriorityQueue<>((a,b)->(a-b));
        queueMin = new PriorityQueue<>((a,b)->(b-a));
    }

    void addNum(int num) {
        if (queueMin.isEmpty() || num <= queueMin.peek()) {
            queueMin.offer(num);
            if (queueMax.size() + 1 < queueMin.size()) {
                queueMax.offer(queueMin.poll());
            }
        } else {
            queueMax.offer(num);
            if (queueMax.size() > queueMin.size()) {
                queueMin.offer(queueMax.poll());
            }
        }
    }

    double findMedian() {
      if(queueMin.size()>queueMax.size()){
          return queueMin.peek();
      }else {
          return (queueMax.peek()+queueMin.peek())/2.0;
      }
    }
}
