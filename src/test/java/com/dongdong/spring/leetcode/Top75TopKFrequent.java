package com.dongdong.spring.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *前k个高频元素
 */
public class Top75TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer,Integer> map=new HashMap<>();
       for(int num:nums){
           map.put(num,map.getOrDefault(num,0)+1);
       }

        PriorityQueue<int[]> priorityQueue=new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] m, int[] n) {
                return m[1]-n[1];
            }
        });
       for(Map.Entry<Integer,Integer> entry:map.entrySet()){
           int num=entry.getKey();
           int value=entry.getValue();
           if(priorityQueue.size()==k){
               if(priorityQueue.peek()[1]<value){
                   priorityQueue.poll();
                   priorityQueue.add(new int[]{num,value});
               }
           }else {
               priorityQueue.add(new int[]{num,value});
           }
       }
       int[] res=new int[k];
       for(int i=0;i<k;i++){
           res[i] =priorityQueue.poll()[0];
       }
       return res;
    }
}
