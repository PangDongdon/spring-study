package com.dongdong.spring.test.sort;

/**
 * 选择排序
 * */

public class SelectionSort {
    public static void main(String[] args) {
        int temp=0;
        int[] arr={2,333,444,1,4,5,6,899};
        for(int i=0;i<arr.length-1;i++){
            int minIndex=i;
            for(int j=i+1;j<arr.length;j++){
               if(arr[j]<arr[minIndex]){
                   minIndex=j;
               }
           }
            if(minIndex!=i){
                temp=arr[minIndex];
                arr[minIndex]=arr[i];
                arr[i]=temp;
            }
        }
        //outPut result
        for(int ss:arr){
            System.out.println(ss);
        }
    }


}
