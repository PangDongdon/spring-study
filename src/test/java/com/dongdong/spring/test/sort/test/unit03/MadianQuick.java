package com.dongdong.spring.test.sort.test.unit03;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MadianQuick {

  private static   PriorityQueue<Integer> maxHeap=new PriorityQueue(new MaxHeapComparator());

  private static   PriorityQueue<Integer> minHeap=new PriorityQueue(new MinHeapComparator());

     public static  void modifyHeap(){
         if(maxHeap.size()==minHeap.size()+2){
             minHeap.add(maxHeap.poll());
         }else if(minHeap.size()==maxHeap.size()+2){
             maxHeap.add(minHeap.poll());
         }
     }


    public static void addNumber(int num){
        if(maxHeap.isEmpty()){
            maxHeap.add(num);
        }
        if(maxHeap.peek()>num){
            maxHeap.add(num);
        }else{
            if(minHeap.isEmpty()){
                minHeap.add(num);
                return;
            }
            if(minHeap.peek()>num){
                maxHeap.add(num);
            }else{
                minHeap.add(num);
            }
        }
        modifyHeap();
    }

    public static  int  getMidNum(){
         int maxHeapSize=maxHeap.size();
         int minHeapSize=minHeap.size();
         if(maxHeapSize+minHeapSize==0){
             return 0;
         }
         int maxHeapValue=maxHeap.peek();
         int minHeapValue=minHeap.peek();
         if(((maxHeapSize+minHeapSize) &1)==0){
             return  (maxHeapValue+minHeapValue)/2;
         }
        return maxHeapSize>minHeapSize ?maxHeapValue:minHeapValue;
    }


    public static  class MinHeapComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
           if(o1<o2){
               return -1;
           }else{
               return 1;
           }
        }
    }


    public static  class MaxHeapComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            if(o1>o2){
                return -1;
            }else{
                return 1;
            }
        }
    }
}
