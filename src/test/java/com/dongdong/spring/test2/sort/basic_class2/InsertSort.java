package com.dongdong.spring.test2.sort.basic_class2;

import com.dongdong.spring.test.region.Util;

public class InsertSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j < arr.length - 1; j--) {
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
