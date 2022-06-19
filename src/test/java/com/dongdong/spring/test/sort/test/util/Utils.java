package com.dongdong.spring.test.sort.test.util;

public  class Utils {

    public  static  int[] arr={2,8,4,0,78,45};
    public  static void swap(int[] arr,int i,int j){
       if(arr==null){
           return;
       }
       int temp=arr[i];
       arr[i]=arr[j];
       arr[j]=temp;
    }

    public static  void printArr(int[] arr){
        for(int i:arr){
            System.out.print(i+"");
        }
    }
}
