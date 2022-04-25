package com.dongdong.spring.test.sort.test.unit01;

import com.dongdong.spring.test.sort.test.util.Utils;

public class MergeSort {

    public static void mergeSort(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        mergeSort(arr, L, mid);
        mergeSort(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int mid, int R) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int p1 = L;
        int p2 = mid + 1;
        int i = 0;
        int[] help = new int[R - L + 1];
        while (p1 <= mid && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (int k = 0; k < help.length; k++) {
            arr[L + k] = help[k];
        }
    }

    public static void main(String[] args) {
        int[] arr = Utils.arr;
        mergeSort(arr, 0, arr.length - 1);
        Utils.printArr(arr);
    }
}
