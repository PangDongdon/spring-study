package com.dongdong.spring.test.sort.test.unit01;

import com.dongdong.spring.test.sort.test.util.Utils;

public class SelectionSort {

    private static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                min = arr[min] > arr[j] ? j : min;
            }
            Utils.swap(arr,min,i);
        }
        Utils.printArr(arr);
    }

    public static void main(String[] args) {
        sort(Utils.arr);
    }

    // 6,5,4
}

