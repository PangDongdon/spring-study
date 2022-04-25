package com.dongdong.spring.test.sort.test.unit08;

import java.util.LinkedList;

public class SlidingWindowMaxArray {

    public static int[] getMaxWindow(int[] arr,int w){
        if(arr==null || w<1 || arr.length<w){
            return  null;
        }
        int[] res=new  int[arr.length-w+1];
        int index=0;
        LinkedList<Integer> linkedList=new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            while(!linkedList.isEmpty() && arr[linkedList.peekLast()]<=arr[i]){
                linkedList.pollLast();
            }
            linkedList.addLast(i);
            if(linkedList.peekFirst()==i-w){
                linkedList.pollFirst();
            }
            if(i+1>=w){
              res[index++]=arr[linkedList.peekFirst()];
            }
        }
        return res;
    }


    // for test
    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 5, 4, 3, 3, 6, 7 };
        int w = 3;
        printArray(getMaxWindow(arr, w));

    }

}
