package com.dongdong.spring.test.sort.test.unit01;

import com.dongdong.spring.test.sort.test.util.Utils;

public class QuickSort {

    public static void sort(int[] arr) {
        if (arr == null) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
        Utils.printArr(arr);
    }

    public static void quickSort(int[] arr, int L, int R) {
        if (L<R) {
            Utils.swap(arr, (L + (int) (Math.random() * (R - L + 1))), R);
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1);
            quickSort(arr, p[1] + 1, R);
        }
    }

    public static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        while (L < more) {
            if (arr[L] < arr[R]) {
                Utils.swap(arr, L++, ++less);
            } else if (arr[L] > arr[R]) {
                Utils.swap(arr, L, --more);
            } else {
                L++;
            }
        }
        Utils.swap(arr, R, more);
       // Utils.printArr(arr);
        return new int[]{less + 1, more};
    }

    public static void main(String[] args) {
        int[] arr = Utils.arr;
        //2
        //8
        //4
        //0
        //45
        //78
        sort(Utils.arr);
        //partition(arr,0,arr.length-1);
    }
}
