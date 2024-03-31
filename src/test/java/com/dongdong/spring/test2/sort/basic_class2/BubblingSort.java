package com.dongdong.spring.test2.sort.basic_class2;

public class BubblingSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    Utils.swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 1, 0};
        sort(arr);
        Utils.printArrRes(arr);
    }
}
