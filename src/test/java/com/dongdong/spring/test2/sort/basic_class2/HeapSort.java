package com.dongdong.spring.test2.sort.basic_class2;

import java.util.Arrays;

public class HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null) {
            return;
        }
        int size = arr.length;
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        Utils.swap(arr, 0, --size);
        if (size > 0) {
            heapfity(arr, 0, size);
            Utils.swap(arr, 0, --size);
        }
    }

    private static void heapfity(int[] arr, int i, int size) {
        int left = i * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[i] > arr[largest] ? i : largest;
            if (i == largest) {
                break;
            }
            Utils.swap(arr, i, largest);
            i = largest;
            left = i * 2 + 1;

        }
    }

    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            Utils.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 2};
        heapSort(arr);
        Utils.printArrRes(arr);
    }
}
