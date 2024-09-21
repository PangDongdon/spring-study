package com.dongdong.spring.leetcode;

import java.util.PriorityQueue;

public class Top76MedianFinder {

    PriorityQueue<Integer> queueMin;
    PriorityQueue<Integer> queueMax;

    public Top76MedianFinder() {
        queueMin = new PriorityQueue<>((a, b) -> b - a);
        queueMax = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
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

    public double findMedian() {
        if (queueMin.size() > queueMax.size()) {
            return queueMin.peek();
        }
        return (queueMin.peek() + queueMax.peek()) / 2.0;
    }
}
