package com.dongdong.spring.test2.sort.basic_class2;

public class Utils {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArrRes(int[] arr) {
        for (int res : arr) {
            System.out.println(res);
        }
    }
}
