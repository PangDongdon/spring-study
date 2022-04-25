package com.dongdong.spring.test.sort.test.unit01;

import com.dongdong.spring.test.sort.test.util.Utils;

public class InsertionSort {

    public static void sort(int[] arr){
        if(arr==null || arr.length<2){
            return;
        }
        for(int i=1;i<arr.length;i++){
            for(int j=i-1;j>-1 && arr[j]>arr[j+1];j--){
                Utils.swap(arr,j,j+1);
            }
        }
        Utils.printArr(arr);
    }

    public static void main(String[] args) {
        sort(Utils.arr);
    }
}
