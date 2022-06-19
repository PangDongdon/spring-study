package com.dongdong.spring.test.alBook.unit01Stack;

import java.util.LinkedList;

public class Class10_MaxSubMinArray {
    public static  int getNum(int[] arr,int k){
        if(arr==null || arr.length<1 || k<0){
            return 0;
        }
        LinkedList<Integer> min=new LinkedList<>();
        LinkedList<Integer> max=new LinkedList<>();
        int res=0;
        int i=0;
        int j=0;
        while (i<arr.length){
            while (j<arr.length){
                if(min.isEmpty() || min.peekFirst()!=j){
                    while (!min.isEmpty() && min.peekFirst()>arr[j]){
                        min.pollLast();
                    }
                    min.addLast(j);
                    while (!max.isEmpty() && max.peekFirst()<=arr[j]){
                        max.pollLast();
                    }
                    max.addLast(j);
                }
                if(arr[max.peekFirst()]-arr[min.peekFirst()]>k){
                    break;
                }
                j++;
            }
            res+=j-i;
            if(max.peekFirst()==i){
                max.pollFirst();
            }
            if(min.peekFirst()==i){
                min.pollFirst();
            }
            i++;
        }
        return  res;
    }

    public static void main(String[] args) {
        
    }
}
