package com.dongdong.spring.leetcode;


import java.util.PriorityQueue;

/**
 *數組中第K个最大元素
 */
public class Top74FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap=new PriorityQueue<Integer>((n1, n2)-> n1-n2);
        for(int num :nums){
            heap.add(num);
            if(heap.size()>k){
                heap.poll();
            }
        }
        return heap.poll();
    }
}
