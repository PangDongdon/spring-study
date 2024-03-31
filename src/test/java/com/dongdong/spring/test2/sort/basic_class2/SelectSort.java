package com.dongdong.spring.test2.sort.basic_class2;

public class SelectSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
                Utils.swap(arr, min, i);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 1, 0};
        sort(arr);
        Utils.printArrRes(arr);
    }
}
