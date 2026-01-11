package com.dongdong.spring.leetcodetop100_3;

import java.util.PriorityQueue;

public class Top78MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public Top78MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> a - b);
        minHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    void addNum(int num) {
        if (minHeap.isEmpty() || num <= minHeap.peek()) {
            minHeap.add(num);
            if (maxHeap.size() + 1 < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        } else {
            maxHeap.add(num);
            if (maxHeap.size() > minHeap.size()) {
                minHeap.add(maxHeap.poll());
            }
        }
    }

    double findMedian() {
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }
}
