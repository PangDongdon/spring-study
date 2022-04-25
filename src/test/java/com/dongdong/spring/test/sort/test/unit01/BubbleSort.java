package com.dongdong.spring.test.sort.test.unit01;

import com.dongdong.spring.test.sort.test.util.Utils;

public class BubbleSort {

    private  static void sort(int[] arr){
        if(arr==null || arr.length<2){
            return;
        }
        for(int i=arr.length-1;i>0;i--){
            for(int j=0;j<arr.length-1;j++){
                 if(arr[j]>arr[j+1]){
                     Utils.swap(arr,j,j+1);
                 }
            }
        }
        Utils.printArr(arr);
    }

    public static void main(String[] args) {
        sort(Utils.arr);
    }
}
